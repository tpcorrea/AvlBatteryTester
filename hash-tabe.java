// hash table created using the AVL E-STORAGE LV DC POWER UNIT INTERFACE CAN ENHANCED SINGLE MODE V2.6

// This message contains voltage, current and power setpoints and is sent at a 
// maximum frequency of 1 kHz.

/* SET_U Voltage setpoint
SET_I Current setpoint */
public class Set_U_I{
    ID = 0xB1;
    UInt32 Set_U; //min/max - 0/1200V
    Int32  Set_I; //min/max - -1200/1200A
}

// This message contains commands for system status control, e.g. switching 
// on/off, etc.

/* SET_SWITCH Toggle main statuses:
0 - OFF
1 - STANDBY
2 - ON
SET_CTRL Control mode:
1 - Voltage control
2 - Current control
3 - Power control
RST_E Pos. edge resets energy counter
RST_Q Pos. edge resets charge counter */
public class Set_switch_ctrl{
    ID = 0xC1;
    int SET_SWITCH; //min/max - 0/7
    int SET_CTRL; //min/max - 0/7
    int RST_E; //min/max - 0/1
    int RST_Q; //min/max - 0/1
}

// This message allows the upper monitoring limits to be set for voltage, current 
// and power. These master limits are sent at 10 Hz and cause the system to 
// switch off when the limits are violated

/* SUPV_U_MX Upper switch-off limit for voltage (SYSTEM ERROR)
SUPV_I_MX Upper switch-off limit for current (SYSTEM ERROR)
SUPV_PWR_MX Upper switch-off limit for power (SYSTEM ERROR) */
public class Set_supv_mx{
    ID = 0x114;
    float SUPV_U_MX; //min/max - 0/1200.0
    float SUPI_U_MX; //min/max - -1200.0/1200.0
    float SUPV_PWR_MX; //min/max - -1440.0/1440.0
}

// This message allows the lower monitoring limits to be set for voltage, current and 
// power. These master limits are sent at 10 Hz and cause the system to switch off 
// when the limits are violated.

/* SUPV_U_MN Lower switch-off limit for voltage
SUPV_I_MN Lower switch-off limit for current
SUPV_PWR_MN Lower power limit for monitoring */
public class Set_supv_mn{
    ID = 0x134;
    float SUPV_U_MN; //min/max - 0/1200.0
    float SUPI_U_MN; //min/max - -1200.0/1200.0
    float SUPV_PWR_MN; //min/max - -1440.0/1440.0
}

// This signal sets the control slopes for the electrical values. The system adjusts 
// the system variables based on these values using a linear ramp function. If the 
// value is set to 0, the system changes its output values abruptly at the greatest 
// possible adjustment speed

// Initial values are specified and the signals for the message SET_U_I_PWR are 
// multiplied by the specified factors before processing by the system

/* SET_U_SLOPE Voltage ramp setpoint
SLOPE = 0 means max. ramp (130.0 V/s)
SET_I_SLOPE Current ramp setpoint
SLOPE = 0 means max. ramp (600.0 A/s)
SET_PWR_SLOPE Power ramp setpoint
SLOPE = 0 means max. Rampe (60.0 kW/s) */
public class Set_slope{
    ID = 0x144;
    float SET_U_SLOPE; //min/max - 0/130.0
    float SET_I_SLOPE; //min/max - 0/600.0
    float SET_PWR_SLOPE; //min/max - 0/60.0
}

// This message allows the upper setpoints limit to be set for voltage, current and 
// power.
// These lower level limits are sent at 100 Hz. The system holds the electrical 
// values within these limits, without the system changing its status when the 
// values are violated.

/* SET_LIM_U_MX Upper limit for operating voltage range
SET_LIM_I_MX Upper limit for operating current range
SET_LIM_PWR_MX Upper limit for operating power range */
public class Set_lim_mx{
    ID = 0x160; 
    float SET_LIM_U_MX; //min/max - 0/1200.0
    float SET_LIM_I_MX; //min/max - -1200.0/1200.0
    float SET_LIM_PWR_MX; //min/max - 0-1440.0/1440.0
}

// This message allows the lower setpoints limit to be set for voltage, current and 
// power. These lower level limits are sent at 100 Hz. The system holds the electrical 
// values within these limits, without the system changing its status when the 
// values are violated.

/* SET_LIM_U_MN Lower limit for operating voltage range
SET_LIM_I_MN Lower limit for operating current range
SET_LIM_PWR_MN Lower limit for operating power range */
public class Set_lim_mn{
    ID = 0x170;
    float SET_LIM_U_MN; //min/max - 0/1200.0
    float SET_LIM_I_MN; //min/max - -1200.0/1200.0
    float SET_LIM_PWR_MN; //min/max - 0-1440.0/1440.0
}

// With the aid of this message it is possible to reset any STOP and other errors 
// present in the system. For safety reasons it is essential to observe the operating 
// instructions for the AVL E-STORAGE LV

/* V_IN_7 Spare. Not used for now.
V_IN_6 Spare. Not used for now.
V_IN_5 Spare. Not used for now.
V_IN_4 Spare. Not used for now.
V_IN_3 Spare. Not used for now.
V_IN_2 Spare. Not used for now.
V_IN_1 Spare. Not used for now.
RST_STOP:
* If the system is in the STANDBY ERROR status, it can be set to the
STANDBY status with an RST_STOP signal.
* If the system is in the SYSTEM ERROR status, it is switched over to the
OFF status by RST_STOP.
* If the PEC is in an error state and the error has been eliminated, this virtual input resets the error state. Raising edged (transition from logical 0 to
logical 1) is needed to redeem the error. */ 

public class Set_virtual_in{
    ID = 0x210;
    int V_IN_7; //min/max - 0/1
    int V_IN_6; //min/max - 0/1
    int V_IN_5; //min/max - 0/1
    int V_IN_4; //min/max - 0/1
    int V_IN_3; //min/max - 0/1
    int V_IN_2; //min/max - 0/1
    int V_IN_1; //min/max - 0/1
    int RST_STOP; //min/max - 0/1
}

// This message allows the discharge mode to be set, and, if required, the 
// discharge time.

/* SET_DCH_MODE Discharge mode active:
0 - No discharge
1 - Discharge via internal circuit
2 - Discharge via chopper off
(Power can still be present on the UUT)
3 - Discharge via discharge unit (discharge unit is optional)
SET_DCH_TIME It is necessary to set the discharge time for mode 1 (discharge via internal
circuit).
The time can be set within the range of 0.0 s … 6553.5 s. */
public class Set_dch{
    ID = 0x22F;
    int SET_DCH_MODE; //min/max - 0/255
    float SET_DCH_TIME; //min/max - 0/6553.5
}

// This message contains the system internal resistance to be emulated, is sent 
// with 10 Hz and is limited to +/- 4 Ohm. It also contains the setpoint for power if 
// the device is in power control mode.

/* SET_RI Internal battery resistance in Ohm
SET_PWR Power setpoint */
public class Ser_ri_pwr{
    ID = 0x274;
    IEEE float SET_RI; //min/max - -4/4
    IEEE float SET_PWR; //min/max - -1440/1440
}

// The message is sent cyclically at a frequency of 10 Hz. 
// The system accepts a switch-on command (change of state from OFF to ON) 
// only after receiving a clearance signal with a value of 1. For this reason, the 
// value 1 must also be sent during operation.

/* CLEARANCE Clearance possibilities:
0 - No clearance
1 - Clearance */
public class Clearance{
    ID = 0x720;
    int CLEARENCE; //min/max - 0/1
}

// This message is required by the TAS to reduce the signal frequencies and the 
// associated reduction of the CAN bus load. 

/* SET_MSRD_CYCLE Frequency of measured signal messages
ACT_U_I and ACT_PWR_CTRL
Possible settings:
1 ms = 1 kHz, 2 ms = 500 Hz, 4 ms = 250 Hz, 10 or any other value = 100 Hz
--
SET_DEM_CYCLE Frequency of demand signal messages
SET_U_I_PWR and SET_SWITCH
Possible settings:
1 ms = 1 kHz, 2 ms = 500 Hz, 4 ms = 250 Hz, 10 or any other value = 100 Hz */
public class Set_cycle_time{
    ID = 0x73F;
    int SET_MSRD_CYCLE; //min/max - 1/1000
    int SET_DEM_CYCLE; //min/max - 1/1000
}

// This message contains the measured values for the current and voltage.

/* ACT_U Measured output voltage
ACT_I Measured output current */
public class Act_U_I{
    ID = 0xA1;
    IEEE float ACT_U; //min/max - ±1.7E-38 (7 digits)
    IEEE float ACT_I; //min/max - ±1.7E-38 (7 digits)
}

// This message contains the output power calculated by the system, the current 
// control mode and the system state

/* ACT_PWR Calculated output power (from current and voltage measurement)
ACT_CTRL_MODE Current control mode (cf. SET_SWITCH_CTRL):
1 - Voltage control
2 - Current control
3 - Power control
ACT_SWITCH Current system state (cf. SET_SWITCH_CTRL):
0 - OFF
1 - STANDBY
2 - ON
5 - SYSTEM ERROR */
public class Act_pwr_switch_ctrl{
    ID = 0xE1;
    IEEE float ACT_PWR; //min/max - ±1.7E-38 (7 digits)
    int ACT_CTRL_MODE; //min/max - 1/3
    int ACT_SWITCH; //min/max - 0/7
}

// This message contains information on the setpoints currently used by the 
// system for voltage and current.

/* ACT_SET_U Current voltage setpoint
ACT_SET_I Present current setpoint */
public class Act_set_U_I{
    ID = 0x108;
    IEEE float ACT_SET_U; //min/max - 0/1200.0
    IEEE float ACT_SET_I; //min/max - -1200.0/1200.0
}

// This message contains information on the monitoring limits used by the system. 
// Upon exceeding a limit the system switches over to the status SYSTEM 
// ERROR.

/* ACT_SUPV_U_MX Upper switch-off limit for voltage
ACT_SUPV_I_MX Upper switch-off limit for current
ACT_SUPV_PWR_MX Upper switch-off limit for power */
public class Act_supv_mx{
    ID = 0x118
    float ACT_SUPV_U_MX; //min/max - 0/1200.0
    float ACT_SUPV_I_MX; //min/max - -1200.0/1200.0
    float ACT_SUPV_PWR_MX; //min/max - -1440.0/1440.0
}

// This message contains information on the monitoring limits used by the system. 
// Upon exceeding a limit the system switches over to the status SYSTEM 
// ERROR.

/* ACT_SUPV_U_MN Lower switch-off limit for voltage
ACT_SUPV_I_MN Lower switch-off limit for current
ACT_SUPV_PWR_MN Lower switch-off limit for power */
public class Act_supv_mn{
    ID = 0x138;
    float ACT_SUPV_U_MN; //min/max - 0/1200.0
    float ACT_SUPV_I_MN; //min/max - -1200.0/1200.0
    float ACT_SUPV_PWR_MN; //min/max - -1440.0/1440.0
}

// This message contains information on the setpoint slopes currently used by the 
// system for voltage, current and power.

/* ACT_U_SLOPE Current slope of the voltage ramp
ACT_I_SLOPE Present slope of the current ramp
ACT_PWR_SLOPE Current slope of the power ramp */
public class Act_set_slope{
    ID = 0x148;
    float ACT_U_SLOPE; //min/max - 0/130.0
    float ACT_I_SLOPE; //min/max - 0/600.0
    float ACT_PWR_SLOPE; //min/max - 0/60.0
}

// This message contains information on the upper limits for the setpoints. The 
// system holds the physical output within these limits, however does not change 
// its state when the limits are violated

/* ACT_LIM_U_MX Upper voltage setpoint
ACT_LIM_I_MX Upper current setpoint
ACT_LIM_PWR_MX Upper voltage setpoint limit */
public class Act_set_lim_mx{
    ID = 0x168; 
    float ACT_LIM_U_MX; //min/max - 0/1200.0
    float ACT_LIM_I_MX; //min/max - -1200.0/1200.0
    float ACT_LIM_PWR_MX; //min/max - 0-1440.0/1440.0
}

// This message contains information on the lower limits for the setpoints. The 
// system holds the physical output within these limits, however does not change 
// its state when the limits are violated

/* ACT_LIM_U_MN Lower limit for operating voltage range
ACT_LIM_I_MN Lower limit for operating current range
ACT_LIM_PWR_MN Lower limit for operating power range */
public class Act_set_lim_mn{
    ID = 0x178;
    float ACT_LIM_U_MN; //min/max - 0/1200.0
    float ACT_LIM_I_MN; //min/max - -1200.0/1200.0
    float ACT_LIM_PWR_MN; //min/max - 0-1440.0/1440.0
}

// This message contains the calculated value of the electrical charge quantity in 
// Ah received by the system during the charge and discharge process. Reset on 
// Power Up.

/* ACT_Q_CH Charge quantity received by system
ACT_Q_DCH Charge quantity output by system */
public class Act_q{
    ID = 0x188;
    IEEE float ACT_Q_CH; //min/max - ±1.7E-38 (7 digits)
    IEEE float ACT_Q_DCH; //min/max - ±1.7E-38 (7 digits)
}

// This message contains information on the calculated electric energy in kWh for 
// the charge and discharge process. Reset on Power Up

/* ACT_E_CH Energy received by system
ACT_E_DCH Energy output by system */
public class Act_e{
    ID = 0x198;
    IEEE float ACT_E_CH; //min/max - 
    IEEE float ACT_E_DCH; //min/max -
}

// This message contains information on the application module in which the AVL 
// E-STORAGE LV is controlled, how many systems in the single or parallel mode 
// are working together and gives information about the system’s function mode

/* ACT_HW_MODE Current system application
0 - Console control
1 - AVL E-STORAGE LV Emulator Online GUI
2 - AVL E-STORAGE LV Tester with CAN connection
ACT_OP_MODE Current operation mode
always 0 = master mode
ACT_NR_NODES Absolute number of systems connected in parallel (1 … 6).
For single operation: 1 */
public class Act_hw_mode{
    ID = 0x208;
    int ACT_HW_MODE; //min/max - 0/2
    int ACT_OP_MODE; //min/max - 0/5
    int NR_NODES; //min/max - 0/255
}

// This message contains information on the discharge mode used by the system - 
// and, if relevant for the discharge mode - the discharge time used.

/* ACT_DCH_MODE Possible discharge modes:
0 - No special discharge
1 - Discharge via internal circuit
2 - Discharge via chopper off/output contactor open
(Power can still be present on the UUT)
3 - Discharge via discharge unit (discharge unit is optional)
ACT_DCH_TIME Current discharge time (relevant for mode 1) */
public class Act_set_dch{
    ID = 0x228;
    int ACT_SET_DCH; //min/max - 0/3
    float ACT_DCH_TIME; //min/max - 0/6553.5
}

// This message contains information on the internal resistance emulated by the 
// system.

/* ACT_SET_RI Actual resistance set value.
ACT_SET_PWR Actual power setpoint. */ 
public class Act_set_ri_pwr{
    ID = 0x278;
    IEEE float ACT_SET_RI; //min/max - -4/4
    IEEE float ACT_SET_PWR; //min/max - -1440/1440
}

// This status message contains the bits reflecting the current system status of the 
// AVL E-STORAGE LV. The system status consists of 64 individual status bits 
// subdivided into 4 status words.
// Detailed information on the individual status bits is given in AVL E-STORAGE LV 
// CAN Interface V2.6 Statusbits on page 48
public class Act_status{

}

// This message contains 64 bits for error identification (reserved for further extensions)
public class Act_status_2{

}

// This message is only available, if the E-STORAGE System is equipped with an 
// A-Isometer.
// The message contains the status of the insulation monitor and the currently 
// measures insulation resistance in kOhms.
public class Act_insulation_mon{

}

// This message indicates possible SYSTEM ERRORs.
public class Act_fault{

}

// This message contains general information on the system
public class AVL_sys_part_id{

}

// This message contains the serial number and unique identification number for 
// the system.
public class ALV_sys_device_id{

}

// This message contains the firmware and interface version used.
public class AVL_sys_ver_sw{

}

// This message contains the upper nominal hardware limits for the specific 
// system.
public class Act_hw_lim_mx{

}

// This message contains the upper hardware limits for U, I and PWR.
public class Act_hw_lim_mn{

}

// This message contains the counter for the system watchdog for monitoring 
// whether the connection has been completed and the system is active.
public class WD{

}

// This message allows the setting for the current cycle time to be checked.
public class Act_cycle_time{
    
}