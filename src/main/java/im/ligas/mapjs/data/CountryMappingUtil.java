/**
 * Copyright (c) 2015 Miroslav Ligas All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package im.ligas.mapjs.data;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Miroslav Ligas
 */
public class CountryMappingUtil {

	private static final Map<String, String> countries = new TreeMap<String, String>() {{
		put("Afghanistan", "AFG");
		put("Aland Islands", "ALA");
		put("Albania", "ALB");
		put("Algeria", "DZA");
		put("American Samoa", "ASM");
		put("Andorra", "AND");
		put("Angola", "AGO");
		put("Anguilla", "AIA");
		put("Antarctica", "ATA");
		put("Antigua and Barbuda", "ATG");
		put("Argentina", "ARG");
		put("Armenia", "ARM");
		put("Aruba", "ABW");
		put("Australia", "AUS");
		put("Austria", "AUT");
		put("Azerbaijan", "AZE");
		put("Bahamas", "BHS");
		put("Bahrain", "BHR");
		put("Bangladesh", "BGD");
		put("Barbados", "BRB");
		put("Belarus", "BLR");
		put("Belgium", "BEL");
		put("Belize", "BLZ");
		put("Benin", "BEN");
		put("Bermuda", "BMU");
		put("Bhutan", "BTN");
		put("Bolivia (Plurinational State of)", "BOL");
		put("Bosnia and Herzegovina", "BIH");
		put("Botswana", "BWA");
		put("Bouvet Island", "BVT");
		put("Brazil", "BRA");
		put("British Virgin Islands", "VGB");
		put("British Indian Ocean Territory", "IOT");
		put("Brunei Darussalam", "BRN");
		put("Bulgaria", "BGR");
		put("Burkina Faso", "BFA");
		put("Burundi", "BDI");
		put("Cambodia", "KHM");
		put("Cameroon", "CMR");
		put("Canada", "CAN");
		put("Cabo Verde", "CPV");
		put("Cayman Islands", "CYM");
		put("Central African Republic", "CAF");
		put("Chad", "TCD");
		put("Chile", "CHL");
		put("China", "CHN");
		put("Hong Kong, Special Administrative Region of China", "HKG");
		put("Macao, Special Administrative Region of China", "MAC");
		put("Christmas Island", "CXR");
		put("Cocos (Keeling) Islands", "CCK");
		put("Colombia", "COL");
		put("Comoros", "COM");
		put("Congo (Brazzaville)", "COG");
		put("Democratic Republic of the Congo", "COD");
		put("Cook Islands", "COK");
		put("Costa Rica", "CRI");
		put("Côte d'Ivoire", "CIV");
		put("Croatia", "HRV");
		put("Cuba", "CUB");
		put("Cyprus", "CYP");
		put("Czech Republic", "CZE");
		put("Denmark", "DNK");
		put("Djibouti", "DJI");
		put("Dominica", "DMA");
		put("Dominican Republic", "DOM");
		put("Ecuador", "ECU");
		put("Egypt", "EGY");
		put("El Salvador", "SLV");
		put("Equatorial Guinea", "GNQ");
		put("Eritrea", "ERI");
		put("Estonia", "EST");
		put("Ethiopia", "ETH");
		put("Falkland Islands (Malvinas)", "FLK");
		put("Faroe Islands", "FRO");
		put("Fiji", "FJI");
		put("Finland", "FIN");
		put("France", "FRA");
		put("French Guiana", "GUF");
		put("French Polynesia", "PYF");
		put("French Southern Territories", "ATF");
		put("Gabon", "GAB");
		put("Gambia", "GMB");
		put("Georgia", "GEO");
		put("Germany", "DEU");
		put("Ghana", "GHA");
		put("Gibraltar", "GIB");
		put("Greece", "GRC");
		put("Greenland", "GRL");
		put("Grenada", "GRD");
		put("Guadeloupe", "GLP");
		put("Guam", "GUM");
		put("Guatemala", "GTM");
		put("Guernsey", "GGY");
		put("Guinea", "GIN");
		put("Guinea-Bissau", "GNB");
		put("Guyana", "GUY");
		put("Haiti", "HTI");
		put("Heard Island and Mcdonald Islands", "HMD");
		put("Holy See (Vatican City State)", "VAT");
		put("Honduras", "HND");
		put("Hungary", "HUN");
		put("Iceland", "ISL");
		put("India", "IND");
		put("Indonesia", "IDN");
		put("Iran (Islamic Republic of)", "IRN");
		put("Iraq", "IRQ");
		put("Ireland", "IRL");
		put("Isle of Man", "IMN");
		put("Israel", "ISR");
		put("Italy", "ITA");
		put("Jamaica", "JAM");
		put("Japan", "JPN");
		put("Jersey", "JEY");
		put("Jordan", "JOR");
		put("Kazakhstan", "KAZ");
		put("Kenya", "KEN");
		put("Kiribati", "KIR");
		put("Democratic People's Republic of Korea", "PRK");
		put("Republic of Korea", "KOR");
		put("Kuwait", "KWT");
		put("Kyrgyzstan", "KGZ");
		put("Lao People's Democratic Republic", "LAO");
		put("Latvia", "LVA");
		put("Lebanon", "LBN");
		put("Lesotho", "LSO");
		put("Liberia", "LBR");
		put("Libya", "LBY");
		put("Liechtenstein", "LIE");
		put("Lithuania", "LTU");
		put("Luxembourg", "LUX");
		put("The former Yugoslav republic of Macedonia", "MKD");
		put("Madagascar", "MDG");
		put("Malawi", "MWI");
		put("Malaysia", "MYS");
		put("Maldives", "MDV");
		put("Mali", "MLI");
		put("Malta", "MLT");
		put("Marshall Islands", "MHL");
		put("Martinique", "MTQ");
		put("Mauritania", "MRT");
		put("Mauritius", "MUS");
		put("Mayotte", "MYT");
		put("Mexico", "MEX");
		put("Micronesia (Federated States of)", "FSM");
		put("Republic of Moldova", "MDA");
		put("Monaco", "MCO");
		put("Mongolia", "MNG");
		put("Montenegro", "MNE");
		put("Montserrat", "MSR");
		put("Morocco", "MAR");
		put("Mozambique", "MOZ");
		put("Myanmar", "MMR");
		put("Namibia", "NAM");
		put("Nauru", "NRU");
		put("Nepal", "NPL");
		put("Netherlands", "NLD");
		put("Netherlands Antilles", "ANT");
		put("New Caledonia", "NCL");
		put("New Zealand", "NZL");
		put("Nicaragua", "NIC");
		put("Niger", "NER");
		put("Nigeria", "NGA");
		put("Niue", "NIU");
		put("Norfolk Island", "NFK");
		put("Northern Mariana Islands", "MNP");
		put("Norway", "NOR");
		put("Oman", "OMN");
		put("Pakistan", "PAK");
		put("Palau", "PLW");
		put("Palestinian Territory, Occupied", "PSE");
		put("Panama", "PAN");
		put("Papua New Guinea", "PNG");
		put("Paraguay", "PRY");
		put("Peru", "PER");
		put("Philippines", "PHL");
		put("Pitcairn", "PCN");
		put("Poland", "POL");
		put("Portugal", "PRT");
		put("Puerto Rico", "PRI");
		put("Qatar", "QAT");
		put("Réunion", "REU");
		put("Romania", "ROU");
		put("Russian Federation", "RUS");
		put("Rwanda", "RWA");
		put("Saint-Barthélemy", "BLM");
		put("Saint Helena", "SHN");
		put("Saint Kitts and Nevis", "KNA");
		put("Saint Lucia", "LCA");
		put("Saint-Martin (French part)", "MAF");
		put("Saint Pierre and Miquelon", "SPM");
		put("Saint Vincent and the Grenadines", "VCT");
		put("Samoa", "WSM");
		put("San Marino", "SMR");
		put("Sao Tome and Principe", "STP");
		put("Saudi Arabia", "SAU");
		put("Senegal", "SEN");
		put("Serbia", "SRB");
		put("Seychelles", "SYC");
		put("Sierra Leone", "SLE");
		put("Singapore", "SGP");
		put("Slovakia", "SVK");
		put("Slovenia", "SVN");
		put("Solomon Islands", "SLB");
		put("Somalia", "SOM");
		put("South Africa", "ZAF");
		put("South Georgia and the South Sandwich Islands", "SGS");
		put("South Sudan", "SSD");
		put("Spain", "ESP");
		put("Sri Lanka", "LKA");
		put("Sudan", "SDN");
		put("Suriname *", "SUR");
		put("Svalbard and Jan Mayen Islands", "SJM");
		put("Swaziland", "SWZ");
		put("Sweden", "SWE");
		put("Switzerland", "CHE");
		put("Syrian Arab Republic (Syria)", "SYR");
		put("Taiwan, Republic of China", "TWN");
		put("Tajikistan", "TJK");
		put("United Republic of Tanzania", "TZA");
		put("Thailand", "THA");
		put("Timor-Leste", "TLS");
		put("Togo", "TGO");
		put("Tokelau", "TKL");
		put("Tonga", "TON");
		put("Trinidad and Tobago", "TTO");
		put("Tunisia", "TUN");
		put("Turkey", "TUR");
		put("Turkmenistan", "TKM");
		put("Turks and Caicos Islands", "TCA");
		put("Tuvalu", "TUV");
		put("Uganda", "UGA");
		put("Ukraine", "UKR");
		put("United Arab Emirates", "ARE");
		put("United Kingdom of Great Britain and Northern Ireland", "GBR");
		put("United States of America", "USA");
		put("United States Minor Outlying Islands", "UMI");
		put("Uruguay", "URY");
		put("Uzbekistan", "UZB");
		put("Vanuatu", "VUT");
		put("Venezuela (Bolivarian Republic of)", "VEN");
		put("Viet Nam", "VNM");
		put("Virgin Islands, US", "VIR");
		put("Wallis and Futuna Islands", "WLF");
		put("Western Sahara", "ESH");
		put("Yemen", "YEM");
		put("Zambia", "ZMB");
		put("Zimbabwe", "ZWE");

	}};

	private static final Log LOG = LogFactoryUtil.getLog(CountryMappingUtil.class);


	public static String getCode(String country){
		String code = countries.get(country);
		if (code == null) {
			for (String name : countries.keySet()) {
				if(name.contains(country)){
					code = countries.get(name);
				}
			}
		}
		if (code == null) {
			LOG.warn("Could not map " + country);
		}
		return code;
	}
}
