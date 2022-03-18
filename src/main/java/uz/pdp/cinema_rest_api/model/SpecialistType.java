package uz.pdp.cinema_rest_api.model;

import java.util.Arrays;

public enum SpecialistType {

    SPECIALIST_ACTOR("ACTOR"),
    SPECIALIST_DIRECTOR("REJISOR");

    String displayName;

    SpecialistType(String displayName) {
        this.displayName = displayName;
    }

    public static SpecialistType getSpecialistByDisplayName(String displayNameDto) {

        return Arrays.stream(
                        SpecialistType.values())
                .filter(castType -> castType.displayName.equals(displayNameDto)).findFirst().get();


    }
}
