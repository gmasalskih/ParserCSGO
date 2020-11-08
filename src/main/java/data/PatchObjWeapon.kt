package data

import java.util.*

enum class WeaponTypes {
    PISTOL,
    HEAVY,
    SMG,
    RIFLE
}

enum class FirestoreCollections {
    MAPS,
    MAP_POINTS,
    RANKS,
    WEAPONS
}


data class PatchObjWeapon(
    val name: String,
    val collection: FirestoreCollections,
    val weaponTypes: WeaponTypes,
) {
    fun getId() = name
        .replace("[^A-Za-z0-9]".toRegex(), " ")
        .trim()
        .replace("\\s+".toRegex(), "_")
        .toLowerCase(Locale.ENGLISH)

    fun getContentsPath(): String = "${collection}/${getId()}/"
    fun getLogo() = "${getId()}.png"
    fun getSprayPattern() = "${getId()}_s.gif"
    fun getRecoilCompensation() = "${getId()}_c.gif"
}