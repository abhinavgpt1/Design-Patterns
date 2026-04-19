enum Action {
    LIGHT_ON, LIGHT_OFF, FAN_ON, FAN_OFF
    // These actions are subject to extension (in context of Mediator pattern)
    // depending on device type and multiplicity.
    // eg. LIGHT_ON_1, LIGHT_OFF_1, LIGHT_ON_2, LIGHT_OFF_2, AC_ON, AC_OFF
}
