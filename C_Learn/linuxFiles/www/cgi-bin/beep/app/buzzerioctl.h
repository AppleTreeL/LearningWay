#ifndef PWM_H__
#define PWM_H__

#include <linux/ioctl.h>

#define PWM_TYPE        'B'

#define PWM_START	     		_IO(PWM_TYPE,1)
#define PWM_SET_FREQ	     		_IO(PWM_TYPE,2)
#define PWM_STOP	     		_IO(PWM_TYPE,3)

#endif
