package preference_network;

import utils.Utils;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LaunchSettings extends UiAutomatorTestCase {

	private void changeMobilePreference() {
		Utils.click(new UiObject(
				new UiSelector().className("android.widget.ListView").instance(0).childSelector(
						new UiSelector()
						.className("android.widget.LinearLayout")
.instance(6))));
		sleep(2000);
		Utils.click(new UiObject(new UiSelector()
.className(
				"android.widget.ListView")
				.childSelector(
						new UiSelector().className(
"android.widget.LinearLayout")
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

		Utils.click(new UiObject(new UiSelector().textContains(stringValue
				.toUpperCase())));
	}

	public void testDemo() throws UiObjectNotFoundException {
		assertTrue("OOOOOpps",
				Utils.openApp(this, "Settings", "com.android.settings"));
		sleep(2000);
		changeMobilePreference();
	}
}

