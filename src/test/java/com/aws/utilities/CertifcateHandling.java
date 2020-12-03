package com.aws.utilities;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class CertifcateHandling {
	public static FirefoxProfile firefoxCertification() {

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile ffProfile = profile.getProfile("myProfile");
		ffProfile.setAcceptUntrustedCertificates(true);
		ffProfile.setAssumeUntrustedCertificateIssuer(false);

		return ffProfile;

	}

}
