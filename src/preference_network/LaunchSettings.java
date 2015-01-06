package preference_network;

import utils.Utils;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LaunchSettings extends UiAutomatorTestCase {

	private void changeMobilePreference() {
		Utils.click(new UiObject(new UiSelector()
				.className("android.widget.ListView")
				.instance(0)
				.childSelector(
						new UiSelector().className(
								"android.widget.LinearLayout").instance(6))));
		sleep(2000);
		Utils.click(new UiObject(new UiSelector().className(
				"android.widget.ListView").childSelector(
				new UiSelector().className("android.widget.LinearLayout")
						.instance(8))));
		sleep(2000);
		Utils.click(new UiObject(new UiSelector()
				.className("android.widget.ListView")
				.instance(0)
				.childSelector(
						new UiSelector().className(
								"android.widget.LinearLayout").instance(4))));
		sleep(2000);
		String stringValue = getParams().getString("network-status");

		if (stringValue == null)
			stringValue = "4G";

		System.out.println("Switch to: " + stringValue);
		Utils.click(new UiObject(new UiSelector().textContains(stringValue
				.toUpperCase())));
	}

	private void avoidPoorConnections(boolean avoidPoorConn)
			throws UiObjectNotFoundException {
		Utils.findLayoutInList("Wi‑Fi", // dash is a UTF8 special char...
				android.widget.RelativeLayout.class.getName(), 0, null, null,
				true).clickAndWaitForNewWindow();
		Utils.getObjectWithDescription("More options")
				.clickAndWaitForNewWindow();
		Utils.getObjectWithText("Advanced").clickAndWaitForNewWindow();
		UiObject checkBox = Utils.findCheckBoxInListWithTitle(
				"android:id/list",
				"Avoid poor connections", null);
		Utils.checkBox(checkBox, avoidPoorConn);
	}

	public void testDemo() throws UiObjectNotFoundException {
		assertTrue("OOOOOpps",
				Utils.openApp(this, "Settings",
						"com.android.settings",
						".Settings"));
		sleep(2000);

		/*
		 * 2 possible params:
		 *  - avoid-poor-conn on/off (wifi option) [on]
		 *  - network-status 4G/3G/2G (network preference) [4G] [default]
		 */

		String avoidPoorConn = getParams().getString("avoid-poor-conn");
		if (avoidPoorConn != null) // default: on
			avoidPoorConnections(!avoidPoorConn.equalsIgnoreCase("off"));
		else
			// default if no arg: 4G
			changeMobilePreference();
	}
}
