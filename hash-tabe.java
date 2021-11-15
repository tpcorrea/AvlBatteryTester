// hash table created using the AVL E-STORAGE LV DC POWER UNIT INTERFACE CAN ENHANCED SINGLE MODE V2.6

import java.text.MessageFormat; //import for use uint32

// This message contains voltage, current and power setpoints and is sent at a 
// maximum frequency of 1 kHz.
public class Set_U_I{
    ID = 0xB1;
    UInt32 Set_U; //min/max - 0/1200V
    Int32  Set_I; //min/max - -1200/1200A
}

// This message contains commands for system status control, e.g. switching 
// on/off, etc.
public class Set_switch_ctrl{

}

// This message allows the upper monitoring limits to be set for voltage, current 
// and power. These master limits are sent at 10 Hz and cause the system to 
// switch off when the limits are violated
public class Set_supv_mx{

}

// This message allows the lower monitoring limits to be set for voltage, current and 
// power. These master limits are sent at 10 Hz and cause the system to switch off 
// when the limits are violated.
public class Set_supv_mn{

}

// This signal sets the control slopes for the electrical values. The system adjusts 
// the system variables based on these values using a linear ramp function. If the 
// value is set to 0, the system changes its output values abruptly at the greatest 
// possible adjustment speed

// Initial values are specified and the signals for the message SET_U_I_PWR are 
// multiplied by the specified factors before processing by the system
public class Set_slope{

}

// This message allows the upper setpoints limit to be set for voltage, current and 
// power.
// These lower level limits are sent at 100 Hz. The system holds the electrical 
// values within these limits, without the system changing its status when the 
// values are violated.
public class Set_lim_mx{

}

// This message allows the lower setpoints limit to be set for voltage, current and 
// power. These lower level limits are sent at 100 Hz. The system holds the electrical 
// values within these limits, without the system changing its status when the 
// values are violated.
public class Set_lim_mn{

}

// With the aid of this message it is possible to reset any STOP and other errors 
// present in the system. For safety reasons it is essential to observe the operating 
// instructions for the AVL E-STORAGE LV
public class Set_virtual_in{

}

// This message allows the discharge mode to be set, and, if required, the 
// discharge time.
public class Set_dch{

}

// This message contains the system internal resistance to be emulated, is sent 
// with 10 Hz and is limited to +/- 4 Ohm. It also contains the setpoint for power if 
// the device is in power control mode.
public class Ser_ri_pwr{

}

// The message is sent cyclically at a frequency of 10 Hz. 
// The system accepts a switch-on command (change of state from OFF to ON) 
// only after receiving a clearance signal with a value of 1. For this reason, the 
// value 1 must also be sent during operation.
public class Clearance{

}

// This message is required by the TAS to reduce the signal frequencies and the 
// associated reduction of the CAN bus load. 
public class Set_cycle_time{

}

// This message contains the measured values for the current and voltage.
public class Act_U_I{

}

// This message contains the output power calculated by the system, the current 
// control mode and the system state
public class Act_pwr_switch_ctrl{

}

// This message contains information on the setpoints currently used by the 
// system for voltage and current.
public class Act_set_U_I{

}

// This message contains information on the monitoring limits used by the system. 
// Upon exceeding a limit the system switches over to the status SYSTEM 
// ERROR.
public class Act_supv_mx{

}

// This message contains information on the monitoring limits used by the system. 
// Upon exceeding a limit the system switches over to the status SYSTEM 
// ERROR.
public class Act_supv_mn{

}

// This message contains information on the setpoint slopes currently used by the 
// system for voltage, current and power.
public class Act_set_slope{

}

// This message contains information on the upper limits for the setpoints. The 
// system holds the physical output within these limits, however does not change 
// its state when the limits are violated
public class Act_set_lim_mx{

}

// This message contains information on the lower limits for the setpoints. The 
// system holds the physical output within these limits, however does not change 
// its state when the limits are violated
public class Act_set_lim_mn{

}

// This message contains the calculated value of the electrical charge quantity in 
// Ah received by the system during the charge and discharge process. Reset on 
// Power Up.
public class Act_q{

}

// This message contains information on the calculated electric energy in kWh for 
// the charge and discharge process. Reset on Power Up
public class Act_e{

}

// This message contains information on the application module in which the AVL 
// E-STORAGE LV is controlled, how many systems in the single or parallel mode 
// are working together and gives information about the system’s function mode
public class Act_hw_mode{

}

// This message contains information on the discharge mode used by the system - 
// and, if relevant for the discharge mode - the discharge time used.
public class Act_set_dch{

}

// This message contains information on the internal resistance emulated by the 
// system.
public class Act_set_ri_pwr{

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