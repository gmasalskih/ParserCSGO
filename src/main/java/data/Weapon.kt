package data

import com.google.gson.annotations.SerializedName

data class Weapon(

    @SerializedName("id")
    val id:String = "",

    @SerializedName("collection")
    val collection:String = "",

    @SerializedName("weapon_type")
    val weaponType: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("contents_path")
    val contentsPath:String = "",

    @SerializedName("logo")
    val logo:String = "",

    @SerializedName("spray_pattern")
    val sprayPattern:String = "",

    @SerializedName("recoil_compensation")
    val recoilCompensation:String = "",

    //Награда за убийство
    @SerializedName("kill_award")
    val killAward: Int = 300,

    //Урон
    @SerializedName("damage")
    val damage: Int = 42,

    //Максимальная скорость играка с оружием
    @SerializedName("max_player_speed")
    val maxPlayerSpeed: Int = 1,

    //Коэфицент силы пробивать укрытия
    @SerializedName("penetration")
    val penetration: Double = 1.0,

    //Емкость обоймы
    @SerializedName("primary_clip_size")
    val primaryClipSize: Int = 0,

    //Максимальное кол-во запасных потронов
    @SerializedName("primary_reserve_ammo_max")
    val primaryReserveAmmoMax: Int = 0,

    //Стоимость оружия
    @SerializedName("in_game_price")
    val inGamePrice: Int = 0,

    //Преднадлежность к стороне. 1 - да, 0 - нет.
    @SerializedName("counter-terrorists")
    val counterTerrorists: Int = 0,

    //Преднадлежность к стороне. 1 - да, 0 - нет.
    @SerializedName("terrorists")
    val terrorists: Int = 0,

    //Коэфицент потери уроны каждые 500U (12.7м)
    @SerializedName("range_modifier")
    val rangeModifier: Double = 0.98,

    //Бронипробиваемость. по бронированным противникам урон умножается на armorRatio / 2.
    @SerializedName("armor_ratio")
    val armorRatio: Double = 1.0,

    //Минимальный интервал между выстрелами следующей пули (измеряется в секундах)
    @SerializedName("cycletime")
    val cycleTime: Double = 0.15,

    //Неточность сидя
    @SerializedName("inaccuracy_crouch")
    val inaccuracyCrouch: Double = 0.0,

    //Неточность сидя доп.
    @SerializedName("inaccuracy_crouch_alt")
    val inaccuracyCrouchAlt: Double = 0.0,

    //Неточность в движении
    @SerializedName("inaccuracy_move")
    val inaccuracyMove: Double = 0.0,

    //Неточность в движении доп.
    @SerializedName("inaccuracy_move_alt")
    val inaccuracyMoveAlt: Double =0.0,

    //Неточность стоя
    @SerializedName("inaccuracy_stand")
    val inaccuracyStand: Double =0.0,

    //Неточность стоя доп.
    @SerializedName("inaccuracy_stand_alt")
    val inaccuracyStandAlt: Double =0.0,

    //величина отдачи по оси X
    @SerializedName("recoil_angle_variance")
    val recoilAngleVariance: Int = 0,

    //величина отдачи по оси X доп.
    @SerializedName("recoil_angle_variance_alt")
    val recoilAngleVarianceAlt: Int = 0,

    //количество отдачи
    @SerializedName("recoil_magnitude")
    val recoilMagnitude: Double = 0.0,

    //количество отдачи доп.
    @SerializedName("recoil_magnitude_alt")
    val recoilMagnitudeAlt: Double = 0.0,

    //величина отклонения отдачи по оси Y
    @SerializedName("recoil_magnitude_variance")
    val recoilMagnitudeVariance: Int = 0,

    //величина отклонения отдачи по оси Y доп.
    @SerializedName("recoil_magnitude_variance_alt")
    val recoilMagnitudeVarianceAlt: Int = 0,

    //Окончательное время востановления прицела сидя
    @SerializedName("recovery_time_crouch_final")
    val recoveryTimeCrouchFinal: Double = 1.0,

    //Окончательное время востановления прицела стоя
    @SerializedName("recovery_time_stand_final")
    val recoveryTimeStandFinal: Double = 1.0,

    //дополнительная погрешность, рассчитанная на пулю
    @SerializedName("spread")
    val spread: Double = 0.0,

    //дополнительная погрешность, рассчитанная на пулю доп
    @SerializedName("spread_alt")
    val spreadAlt: Double = 0.0
){
    fun getAA() = "asdsadasd"
}