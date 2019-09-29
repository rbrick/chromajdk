package io.rcw.chromajdk.sdk.internals.razer;

import com.sun.jna.platform.win32.Guid;

import java.util.Arrays;
import java.util.List;

public enum RazerDevices {

    KEYBOARD(
            Guid.GUID.fromString("{2EA1BB63-CA28-428D-9F06-196B88330BBB}"), //! Razer Blackwidow Chroma device.
            Guid.GUID.fromString("{ED1C1B82-BFBE-418F-B49D-D03F05B149DF}"), //! Razer Blackwidow Chroma Tournament Edition device.
            Guid.GUID.fromString("{18C5AD9B-4326-4828-92C4-2669A66D2283}"), //! Razer Deathstalker device.
            Guid.GUID.fromString("{872AB2A9-7959-4478-9FED-15F6186E72E4}"), //! Overwatch Keyboard.
            Guid.GUID.fromString("{5AF60076-ADE9-43D4-B574-52599293B554}"), //! Razer Blackwidow X Chroma device.
            Guid.GUID.fromString("{2D84DD51-3290-4AAC-9A89-D8AFDE38B57C}"), //! Razer Blackwidow X TE Chroma device.
            Guid.GUID.fromString("{803378C1-CC48-4970-8539-D828CC1D420A}"), //! Razer Ornata Chroma
            Guid.GUID.fromString("{C83BDFE8-E7FC-40E0-99DB-872E23F19891}"), //! Razer Blade Stealth.
            Guid.GUID.fromString("{F2BEDFAF-A0FE-4651-9D41-B6CE603A3DDD}"), //! Razer Blade
            Guid.GUID.fromString("{A73AC338-F0E5-4BF7-91AE-DD1F7E1737A5}"), //! Razer Blade Pro
            Guid.GUID.fromString("{F85E7473-8F03-45B6-A16E-CE26CB8D2441}"), //! Razer Huntsman
            Guid.GUID.fromString("{16BB5ABD-C1CD-4CB3-BDF7-62438748BD98}")  //! Razer Blackwidow Elite
    ),
    MOUSE(
            Guid.GUID.fromString("{AEC50D91-B1F1-452F-8E16-7B73F376FDF3}"), //! Razer Deathadder Chroma device.
            Guid.GUID.fromString("{7EC00450-E0EE-4289-89D5-0D879C19061A}"), //! Razer Mamba Chroma Tournament Edition device.
            Guid.GUID.fromString("{FF8A5929-4512-4257-8D59-C647BF9935D0}"), //! Razer Diamondback device.
            Guid.GUID.fromString("{D527CBDC-EB0A-483A-9E89-66D50463EC6C}"), //! Razer Mamba device
            Guid.GUID.fromString("{D714C50B-7158-4368-B99C-601ACB985E98}"), //! Razer Naga Epic device.
            Guid.GUID.fromString("{F1876328-6CA4-46AE-BE04-BE812B414433}"), //! Razer Naga device.
            Guid.GUID.fromString("{52C15681-4ECE-4DD9-8A52-A1418459EB34}"), //! Razer Orochi Chroma device
            Guid.GUID.fromString("{195D70F5-F285-4CFF-99F2-B8C0E9658DB4}"), //! Razer Naga Hex Chroma device.
            Guid.GUID.fromString("{77834867-3237-4A9F-AD77-4A46C4183003}")  //! Razer DeathAdder Elite Chroma device.
    );


    private List<Guid.GUID> deviceIds;

    RazerDevices(Guid.GUID... deviceIds) {
        this.deviceIds = Arrays.asList(deviceIds);
    }

    public List<Guid.GUID> getDeviceIds() {
        return deviceIds;
    }

}
