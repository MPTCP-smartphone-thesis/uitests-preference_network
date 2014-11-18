uitests-preference_network
==========================

A UI test to change the preference from 4G to 3G or from 3G to 4G

To run it, you have to give a value to the key `network-status`.
It means,

`uiautomator runtest UiTest.jar -e network-status network-type`

`network-type` must be either `2G`, `3G` or `4G`.
So the valid lines are

`uiautomator runtest UiTest.jar -e network-status 4G`

`uiautomator runtest UiTest.jar -e network-status 3G`

`uiautomator runtest UiTest.jar -e network-status 2G`
