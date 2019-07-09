#ifndef __IOCTL_H__
#define __IOCTL_H__

#include <linux/ioctl.h>

#define HC_SR501_TYPE	'H'

#define ENABLE_ALARM	_IOW(HC_SR501_TYPE, 0, int)
#define DISABLE_ALARM	_IOW(HC_SR501_TYPE, 1, int)
#define GET_STAT	_IOR(HC_SR501_TYPE, 2, int)

#define BEEP_TYPE 'B'
#define BEEP_SET_HZ  _IOW(BEEP_TYPE, 0, int)
#define BEEP_MUTE    _IO(BEEP_TYPE, 1)

#endif
