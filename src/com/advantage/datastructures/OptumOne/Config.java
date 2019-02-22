package com.advantage.datastructures.OptumOne;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.advantage.fileutils.VTD_XML;
import com.advantage.reporting.Logs;

/**
 * This class read config file 
 * @author Administrator
 *
 */
public class Config {
	private String sConfigFilePath;
	private String sBrowserType;
	private String sAppURL;	
	private String sUserName;
	private String sPassword;
	private String sResultPath;	
	private String sSMTPSever;
	private String sFromEmailId;
	private String sSMTPPassword;
	private String sToEmailId;
	private String sSubject;
	private String sMessage;

	private Integer iPageTimeoutInSeconds;
	private Integer iElementTimeoutInSeconds;
	private Integer iPollIntervalInMilliSeconds;
	private boolean bIsSendEmails;
	private boolean bIsCaptureScreenshots;
	private String sTestDataPath;
	private String sSMTPPort;	
	private String sTestEnvironment;
	private String sTestDataCriteria;
	private String sORPath;

	private HashMap<String, String> mapCustomConfig = new HashMap<String, String>();
	
	
	private String sCarePathwayOwner;
	private String sCarePathwayOwnerPassword;
	private String sOrderUser;
	private String sOrderPassword;
	
	
	

	/**
	 * Method for config path
	 * @param sConfigPath
	 */	
	public Config(String sConfigPath)
	{
		sConfigFilePath = sConfigPath;
	}

	/**
	 * Method to get Config Filepath
	 * @return
	 */
	public String getsConfigFilePath()
	{
		return sConfigFilePath;
	}

	/**
	 * @return the sBrowserType
	 */
	public String getsBrowserType()
	{
		return sBrowserType;
	}

	/**
	 * @param sBrowserType the sBrowserType to set
	 */
	public void setsBrowserType(String sBrowserType)
	{
		this.sBrowserType = sBrowserType;
	}
	
	/**
	 * @return the sAppURL
	 */
	public String getsAppURL()
	{
		return sAppURL;
	}
	
	/**
	 * @return the sAppURL
	 */
	public String getxmldata(String xmlnode)
	{
		return sAppURL;
	}

	/**
	 * @return the sUserName
	 */
	public String getsUserName()
	{
		return sUserName;
	}
	
	/**
	 * @return the sPassword
	 */
	public String getsPassword()
	{
		return sPassword;
	}
	
	/**
	 * @return the sCarePathwayOwner
	 */
	public String getsCarePathwayOwner()
	{
		return sCarePathwayOwner;
	}
	
	/**
	 * @return the sCarePathwayOwnerPassword
	 */
	public String getsCarePathwayOwnerPassword()
	{
		return sCarePathwayOwnerPassword;
	}
	
	
	
	
	/**
	 * @return the sResultPath
	 */
	public String[] getsResultPath()
	{
		String[] path = sResultPath.split("//");
		return path;
	}

	/**
	 * @return the iPageTimeoutInSeconds
	 */
	public Integer getiPageTimeoutInSeconds()
	{
		return iPageTimeoutInSeconds;
	}

	/**
	 * @return the iElementTimeoutInSeconds
	 */
	public Integer getiElementTimeoutInSeconds()
	{
		return iElementTimeoutInSeconds;
	}

	/**
	 * @return the iPollIntervalInMilliSeconds
	 */
	public Integer getiPollIntervalInMilliSeconds()
	{
		return iPollIntervalInMilliSeconds;
	}

	/**
	 * @return the bIsSendEmails
	 */
	public boolean isbIsSendEmails()
	{
		return bIsSendEmails;
	}

	/**
	 * @return the bIsCaptureScreenshots
	 */
	public boolean isbIsCaptureScreenshots()
	{
		return bIsCaptureScreenshots;
	}

	/**
	 * @return the mapCustomConfig
	 */
	public HashMap<String, String> getMapCustomConfig()
	{
		return mapCustomConfig;
	}

	/**
	 * @return the sTestDataPath
	 */
	public String getTestDataPath()
	{
		return sTestDataPath;
	}

	/**
	 * @param sTestDataPath the sTestDataPath to set
	 */
	public void setTestDataPath(String sTestDataPath)
	{
		this.sTestDataPath = sTestDataPath;
	}
	
	/**
	 * @return the sORPath
	 */
	public String getORPath()
	{
		return sORPath;
	}

	/**
	 * @param sORPath the sORPath to set
	 */
	public void setORPath(String sORPath)
	{
		this.sORPath = sORPath;
	}

		
	/**
	 * @return the sSMTPPort
	 */
	public String getsSMTPPort()
	{
		return sSMTPPort;
	}

	/**
	 * @param sSMTPPort the sSMTPPort to set
	 */
	public void setsSMTPPort(String sSMTPPort)
	{
		this.sSMTPPort = sSMTPPort;
	}
	
	/**
	 * @return the sSMTPServer
	 */
	public String getsSMTPSever()
	{
		return sSMTPSever;
	}

	/**
	 * @param sSMTPSever the sSMTPSever to set
	 */
	public void setsSMTPSever(String sSMTPSever)
	{
		this.sSMTPSever = sSMTPSever;
	}
	
	/**
	 * @return the sFromEmailId
	 */
	public String getsFromEmailId()
	{
		return sFromEmailId;
	}

	/**
	 * @param sFromEmailId the sFromEmailId to set
	 */
	public void setsFromEmailId(String sFromEmailId)
	{
		this.sFromEmailId = sFromEmailId;
	}
	
	/**
	 * @return the sSMTPPassword
	 * 
	 */
	public String getsSMTPPassword()
	{
		return sSMTPPassword;
	}

	/**
	 * @param sFromEmailId the sFromEmailId to set
	 */
	public void setsSMTPPassword(String sSMTPPassword)
	{
		this.sSMTPPassword = sSMTPPassword;
	}
	
	/**
	 * @return the sToEmailId
	 */
	public String[] getsToEmailId()
	{
		String[] arr = sToEmailId.split(",");
		return arr;
	}

	/**
	 * @param sToEmailId the sToEmailId to set
	 */
	public void setsToEmailId(String sToEmailId)
	{
		this.sToEmailId = sToEmailId;
	}
	
	/**
	 * @return the sTestEnvironment
	 */
	public String getsTestEnvironment()
	{
		return sTestEnvironment;
	}

	/**
	 * @param sTestEnvironment the sTestEnvironment to set
	 */
	public void setsTestEnvironment(String sTestEnvironment)
	{
		this.sTestEnvironment = sTestEnvironment;
	}
	
	/**
	 * @return the sMessage
	 */
	public String getsMessage()
	{
		return sMessage;
	}

	/**
	 * @param sMessage the sMessage to set
	 */
	public void setsMessage(String sMessage)
	{
		this.sMessage = sMessage;
	}
	
	/**
	 * @return the sSubject
	 */
	public String getsSubject()
	{
		return sSubject;
	}

	/**
	 * @param sSubject the sSubject to set
	 */
	public void setsSubject(String sSubject)
	{
		this.sSubject = sSubject;
	}
	
	/**
	 * @return the sTestDataCriteria
	 */
	public String getsTestDataCriteria()
	{
		return sTestDataCriteria;
	}

	/**
	 * @param sTestDataCriteria the sTestDataCriteria to set
	 */
	public void setsTestDataCriteria(String sTestDataCriteria)
	{
		this.sTestDataCriteria = sTestDataCriteria;
	}

	/**
	 * THis method read config file and set values for each node of xml file
	 */
	
	public void initialize()
	{
		String sConfigFilePath = getsConfigFilePath();
		VTD_XML xml;
		String sXpathRoot = "//config/Fixed";
		String sXpathRootCustom = "//config/Custom/*";

		try
		{
			xml = new VTD_XML(sConfigFilePath);
			int iNodesCount = xml.getNodesCount(sXpathRootCustom);
			sBrowserType = xml.getNodeValue(sXpathRoot + "/AppConfig/Browser", "");
			sResultPath = xml.getNodeValue(sXpathRoot + "/AppConfig/ResultsPath", "");
			sAppURL = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/URL", "");
			sUserName = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/UserName", "");
			sPassword = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/Password", "");
			/*
			 * Different User Roles credentials
			 */
			sCarePathwayOwner = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/CarePathwayOwner", "");
			sCarePathwayOwnerPassword = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/CarePathwayOwnerPassword", "");
			
			sOrderUser = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/CarePathwayOwner", "");
			sOrderPassword = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/CarePathwayOwnerPassword", "");
		
			
			sSMTPPort = xml.getNodeValue(sXpathRoot + "/AppConfig/SMTPPort", "");
			
			iPageTimeoutInSeconds = Integer.parseInt(xml.getNodeValue(sXpathRoot
					+ "/FrameworkConfig/PageTimeoutInSeconds", ""));
			iElementTimeoutInSeconds = Integer.parseInt(xml.getNodeValue(sXpathRoot
					+ "/FrameworkConfig/ElementTimeoutInSeconds", ""));
			iPollIntervalInMilliSeconds = Integer.parseInt(xml.getNodeValue(sXpathRoot
					+ "/FrameworkConfig/PollIntervalInMilliSeconds", ""));
			bIsSendEmails = Boolean.parseBoolean(xml.getNodeValue(sXpathRoot + "/FrameworkConfig/SendEmails",
					""));
			bIsCaptureScreenshots = Boolean.parseBoolean(xml.getNodeValue(sXpathRoot
					+ "/FrameworkConfig/CaptureScreenshots", ""));
			
			sTestDataPath = System.getProperty("user.dir") + System.getProperty("file.separator")
					+ xml.getNodeValue(sXpathRoot + "/FrameworkConfig/TestDataPath", "")
					+ System.getProperty("file.separator");
			sORPath = System.getProperty("user.dir") + System.getProperty("file.separator")
					+ xml.getNodeValue(sXpathRoot + "/FrameworkConfig/ORPath", "")
					+ System.getProperty("file.separator");
			sSMTPSever = xml.getNodeValue(sXpathRoot + "/AppConfig/SMTPServer", "");
			sFromEmailId = xml.getNodeValue(sXpathRoot + "/AppConfig/FromEmailAddress", "");
			sSMTPPassword=xml.getNodeValue(sXpathRoot + "/AppConfig/FromEmailPassword", "");
			sToEmailId = xml.getNodeValue(sXpathRoot + "/AppConfig/ToEmailAddress", "");
			sSubject = xml.getNodeValue(sXpathRoot + "/AppConfig/Subject", "");
			sMessage = xml.getNodeValue(sXpathRoot + "/AppConfig/Message", "");
						
			sTestEnvironment = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/TestEnvironment", "");
			sTestDataCriteria = xml.getNodeValue(sXpathRoot + "/AppConfig/ENV/TestDataCriteria", "");
			

			for (int i = 1; i <= iNodesCount; i++)
			{
				String sName = xml.getNodeName(sXpathRootCustom + "[" + String.valueOf(i) + "]", "");
				String sValue = xml.getNodeValue(sXpathRootCustom + "[" + String.valueOf(i) + "]", "");
				mapCustomConfig.put(sName, sValue);
			}
		}
		catch (Exception exception)
		{
			Logs.logException("Exception occured while opening or reading config XML file " + sConfigFilePath
					+ ". \nException: " + exception.getMessage() + "\nPlease check...", exception);
		}
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bIsCaptureScreenshots ? 1231 : 1237);
		result = prime * result + (bIsSendEmails ? 1231 : 1237);
		result = prime
				* result
				+ ((iElementTimeoutInSeconds == null) ? 0
						: iElementTimeoutInSeconds.hashCode());
		result = prime
				* result
				+ ((iPageTimeoutInSeconds == null) ? 0 : iPageTimeoutInSeconds
						.hashCode());
		result = prime
				* result
				+ ((iPollIntervalInMilliSeconds == null) ? 0
						: iPollIntervalInMilliSeconds.hashCode());
		result = prime * result
				+ ((mapCustomConfig == null) ? 0 : mapCustomConfig.hashCode());
		result = prime * result + ((sAppURL == null) ? 0 : sAppURL.hashCode());
		result = prime * result
				+ ((sBrowserType == null) ? 0 : sBrowserType.hashCode());
		result = prime
				* result
				+ ((sCarePathwayOwner == null) ? 0 : sCarePathwayOwner
						.hashCode());
		result = prime
				* result
				+ ((sCarePathwayOwnerPassword == null) ? 0
						: sCarePathwayOwnerPassword.hashCode());
		result = prime * result
				+ ((sConfigFilePath == null) ? 0 : sConfigFilePath.hashCode());
		result = prime * result
				+ ((sFromEmailId == null) ? 0 : sFromEmailId.hashCode());
		result = prime * result
				+ ((sMessage == null) ? 0 : sMessage.hashCode());
		result = prime * result + ((sORPath == null) ? 0 : sORPath.hashCode());
		result = prime * result
				+ ((sPassword == null) ? 0 : sPassword.hashCode());
		result = prime * result
				+ ((sResultPath == null) ? 0 : sResultPath.hashCode());
		result = prime * result
				+ ((sSMTPPassword == null) ? 0 : sSMTPPassword.hashCode());
		result = prime * result
				+ ((sSMTPPort == null) ? 0 : sSMTPPort.hashCode());
		result = prime * result
				+ ((sSMTPSever == null) ? 0 : sSMTPSever.hashCode());
		result = prime * result
				+ ((sSubject == null) ? 0 : sSubject.hashCode());
		result = prime
				* result
				+ ((sTestDataCriteria == null) ? 0 : sTestDataCriteria
						.hashCode());
		result = prime * result
				+ ((sTestDataPath == null) ? 0 : sTestDataPath.hashCode());
		result = prime
				* result
				+ ((sTestEnvironment == null) ? 0 : sTestEnvironment.hashCode());
		result = prime * result
				+ ((sToEmailId == null) ? 0 : sToEmailId.hashCode());
		result = prime * result
				+ ((sUserName == null) ? 0 : sUserName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Config other = (Config) obj;
		if (bIsCaptureScreenshots != other.bIsCaptureScreenshots)
			return false;
		if (bIsSendEmails != other.bIsSendEmails)
			return false;
		if (iElementTimeoutInSeconds == null) {
			if (other.iElementTimeoutInSeconds != null)
				return false;
		} else if (!iElementTimeoutInSeconds
				.equals(other.iElementTimeoutInSeconds))
			return false;
		if (iPageTimeoutInSeconds == null) {
			if (other.iPageTimeoutInSeconds != null)
				return false;
		} else if (!iPageTimeoutInSeconds.equals(other.iPageTimeoutInSeconds))
			return false;
		if (iPollIntervalInMilliSeconds == null) {
			if (other.iPollIntervalInMilliSeconds != null)
				return false;
		} else if (!iPollIntervalInMilliSeconds
				.equals(other.iPollIntervalInMilliSeconds))
			return false;
		if (mapCustomConfig == null) {
			if (other.mapCustomConfig != null)
				return false;
		} else if (!mapCustomConfig.equals(other.mapCustomConfig))
			return false;
		if (sAppURL == null) {
			if (other.sAppURL != null)
				return false;
		} else if (!sAppURL.equals(other.sAppURL))
			return false;
		if (sBrowserType == null) {
			if (other.sBrowserType != null)
				return false;
		} else if (!sBrowserType.equals(other.sBrowserType))
			return false;
		if (sCarePathwayOwner == null) {
			if (other.sCarePathwayOwner != null)
				return false;
		} else if (!sCarePathwayOwner.equals(other.sCarePathwayOwner))
			return false;
		if (sCarePathwayOwnerPassword == null) {
			if (other.sCarePathwayOwnerPassword != null)
				return false;
		} else if (!sCarePathwayOwnerPassword
				.equals(other.sCarePathwayOwnerPassword))
			return false;
		if (sConfigFilePath == null) {
			if (other.sConfigFilePath != null)
				return false;
		} else if (!sConfigFilePath.equals(other.sConfigFilePath))
			return false;
		if (sFromEmailId == null) {
			if (other.sFromEmailId != null)
				return false;
		} else if (!sFromEmailId.equals(other.sFromEmailId))
			return false;
		if (sMessage == null) {
			if (other.sMessage != null)
				return false;
		} else if (!sMessage.equals(other.sMessage))
			return false;
		if (sORPath == null) {
			if (other.sORPath != null)
				return false;
		} else if (!sORPath.equals(other.sORPath))
			return false;
		if (sPassword == null) {
			if (other.sPassword != null)
				return false;
		} else if (!sPassword.equals(other.sPassword))
			return false;
		if (sResultPath == null) {
			if (other.sResultPath != null)
				return false;
		} else if (!sResultPath.equals(other.sResultPath))
			return false;
		if (sSMTPPassword == null) {
			if (other.sSMTPPassword != null)
				return false;
		} else if (!sSMTPPassword.equals(other.sSMTPPassword))
			return false;
		if (sSMTPPort == null) {
			if (other.sSMTPPort != null)
				return false;
		} else if (!sSMTPPort.equals(other.sSMTPPort))
			return false;
		if (sSMTPSever == null) {
			if (other.sSMTPSever != null)
				return false;
		} else if (!sSMTPSever.equals(other.sSMTPSever))
			return false;
		if (sSubject == null) {
			if (other.sSubject != null)
				return false;
		} else if (!sSubject.equals(other.sSubject))
			return false;
		if (sTestDataCriteria == null) {
			if (other.sTestDataCriteria != null)
				return false;
		} else if (!sTestDataCriteria.equals(other.sTestDataCriteria))
			return false;
		if (sTestDataPath == null) {
			if (other.sTestDataPath != null)
				return false;
		} else if (!sTestDataPath.equals(other.sTestDataPath))
			return false;
		if (sTestEnvironment == null) {
			if (other.sTestEnvironment != null)
				return false;
		} else if (!sTestEnvironment.equals(other.sTestEnvironment))
			return false;
		if (sToEmailId == null) {
			if (other.sToEmailId != null)
				return false;
		} else if (!sToEmailId.equals(other.sToEmailId))
			return false;
		if (sUserName == null) {
			if (other.sUserName != null)
				return false;
		} else if (!sUserName.equals(other.sUserName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Config [sConfigFilePath=" + sConfigFilePath + ", sBrowserType="
				+ sBrowserType + ", sAppURL=" + sAppURL + ", sUserName="
				+ sUserName + ", sPassword=" + sPassword + ", sResultPath="
				+ sResultPath + ", sSMTPSever=" + sSMTPSever
				+ ", sFromEmailId=" + sFromEmailId + ", sSMTPPassword="
				+ sSMTPPassword + ", sToEmailId=" + sToEmailId + ", sSubject="
				+ sSubject + ", sMessage=" + sMessage
				+ ", iPageTimeoutInSeconds=" + iPageTimeoutInSeconds
				+ ", iElementTimeoutInSeconds=" + iElementTimeoutInSeconds
				+ ", iPollIntervalInMilliSeconds="
				+ iPollIntervalInMilliSeconds + ", bIsSendEmails="
				+ bIsSendEmails + ", bIsCaptureScreenshots="
				+ bIsCaptureScreenshots + ", sTestDataPath=" + sTestDataPath
				+ ", sSMTPPort=" + sSMTPPort + ", sTestEnvironment="
				+ sTestEnvironment + ", sTestDataCriteria=" + sTestDataCriteria
				+ ", sORPath=" + sORPath + ", mapCustomConfig="
				+ mapCustomConfig + ", sCarePathwayOwner=" + sCarePathwayOwner
				+ ", sCarePathwayOwnerPassword=" + sCarePathwayOwnerPassword
				+ "]";
	}

	@Test
	public static void unitTest()
	{
		Logs.initializeLoggers();
		System.out.println(System.getProperty("user.dir") + "\\testLink_config.xml");
		Config config = new Config(System.getProperty("user.dir") + "\\testLink_config.xml");
		config.initialize();
		System.out.println(config.toString());
	}

}
