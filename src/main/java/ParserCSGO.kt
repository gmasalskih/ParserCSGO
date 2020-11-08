import com.google.gson.GsonBuilder
import data.Weapon
import data.mapPathes
import java.io.File

class ParserCSGO(private val pathToFile: String, private val fileName: String) {
    private val sb = StringBuilder()
    private val listWeapons = mutableListOf<MutableMap<String, String>>()
    private val listObjWeapons = mutableListOf<Weapon>()
    private val correctListWeapon = mutableListOf<Weapon>()
    private val gson = GsonBuilder().create()

    fun parsToMap() {
        var ready = false
        var start = false
        var weaponMap = mutableMapOf<String, String>()
        val fieldRegex = Regex("\"\\s+\"")
        File("${pathToFile}$fileName").forEachLine { str ->
            val txt = str.trim()
            if (txt.contains(Regex("^\"weapon_[a-z_0-9]+_prefab\"$"))) {
                if (weaponMap.isNotEmpty()) listWeapons.add(weaponMap)
                weaponMap = mutableMapOf()
                weaponMap["name"] = txt.replace("\"", "")
                    .replace("weapon_", "")
                    .replace("_prefab", "")
                ready = true
            }
            if (ready) {
                if (txt.contains(Regex("^\"attributes\"$")) ||
                    txt.contains(Regex("^\"used_by_classes\"$")) ||
                    txt.contains(Regex("^\"visuals\"$"))
                ) start = true
            }
            if (ready && start) {
                when {
                    txt.contains(fieldRegex) -> {
                        val list = txt.replace(fieldRegex, "\":\"")
                            .replace(Regex("\\s+"), "_")
                            .replace("\"", "")
                            .split(":")
                        weaponMap[list[0]] = list[1]
                    }
                    txt.contains("}") -> {
                        start = false
                    }
                }
            }
        }

//        sb.appendLine("{")
//        weaponMap.toList().forEachIndexed { index1, pair1 ->
//            sb.appendLine(" \"${pair1.first}\":{")
//            pair1.second.toList().forEachIndexed { index2, pair2 ->
//                sb.appendLine("     \"${pair2.first}\":\"${pair2.second}\"${if (index2 + 1 < pair1.second.size) "," else ""}")
//            }
//            sb.appendLine(" }${if (index1 + 1 < weaponMap.size) "," else ""}")
//        }
//        sb.appendLine("}")
//
//        //./src/main/resources/weapons.json
//        File("${weaponName}weapons.json").writeText(sb.toString())

        println("parsToMap done")
        parseToJSON()
    }

    fun makeFile(){
        File("${pathToFile}weapons.json").writeText(gson.toJson(correctListWeapon))
    }

    fun correctWeapons(){
        listObjWeapons.forEach {
            if (mapPathes.containsKey(it.name)){
                mapPathes.getValue(it.name).apply {
                    correctListWeapon.add(
                        it.copy(
                            name = name,
                            collection = collection.name,
                            weaponType = weaponTypes.name,
                            id = getId(),
                            contentsPath = getContentsPath(),
                            logo = getLogo(),
                            sprayPattern = getSprayPattern(),
                            recoilCompensation = getRecoilCompensation()
                        )
                    )
                }
            }
        }
        println("correctWeapons done")
        makeFile()
    }

    fun parseToJSON() {
        listWeapons.forEach { mutableMap ->
            sb.clear()
            sb.appendLine("{")
            mutableMap.toList().forEachIndexed { index, pair ->
                sb.appendLine(
                    "\"${pair.first}\":\"${pair.second}\"${if (index + 1 < mutableMap.size) "," else ""}"
                )
            }
            sb.appendLine("}")
            gson.fromJson(sb.toString(), Weapon::class.java).let { weapon ->
                if (weapon.weaponType.isNotEmpty()) listObjWeapons.add(weapon)
            }
        }
        println("parseToJSON done")
        correctWeapons()
    }
}