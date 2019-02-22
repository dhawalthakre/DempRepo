package com.advantage.datastructures.OptumOne;

import java.util.Arrays;

public class SendEmailDetails {
	public String sSMPT_Server;
	public String sFromEmailAddress;
	public String[] sToEmailAddresses;
	public String sSubject;
	public String sMessageText;
	public String[] sFileAttachments;
	public String sPathSeparator;
	public String sNewLine;
	public String sSMTPPort;
	public String sSMTPPassword;

	/**
	 * Constructor for windows OS. (For other OS, use constructor with
	 * sPathSeparator)
	 * 
	 * @param sSMPT_Server - Server to use to send message
	 * @param sFromEmailAddress - Address that the message will displayed from
	 * @param sToEmailAddresses - E-mail addresses of the recipients
	 * @param sSubject - Subject line of the message
	 * @param sMessageText - Message text of the e-mail
	 * @param sFileAttachments - Location of attachments to send
	 */
	public SendEmailDetails(String sSMPT_Server, String sSMTPPort, String sFromEmailAddress, String sSMTPPassword, String[] sToEmailAddresses,
			String sSubject, String sMessageText, String[] sFileAttachments)
	{

		init(sSMPT_Server, sSMTPPort, sFromEmailAddress, sSMTPPassword, sToEmailAddresses, sSubject, sMessageText, sFileAttachments);

		// On Windows the path separator is \
		this.sPathSeparator = "[\\\\]";
		this.sNewLine = "\r\n";
	}

	/**
	 * Constructor for non-windows OS
	 * 
	 * @param sSMPT_Server - Server to use to send message
	 * @param sFromEmailAddress - Address that the message will displayed from
	 * @param sToEmailAddresses - E-mail addresses of the recipients
	 * @param sSubject - Subject line of the message
	 * @param sMessageText - Message text of the e-mail
	 * @param sFileAttachments - Location of attachments to send
	 * @param sPathSeparator - The path separator used to split the file location and determine the filename
	 * @param sNewLine - New Line feed for use with log4j
	 */
	public SendEmailDetails(String sSMPT_Server, String sSMTPPort, String sFromEmailAddress, String sSMTPPassword, String[] sToEmailAddresses,
			String sSubject, String sMessageText, String[] sFileAttachments, String sPathSeparator,
			String sNewLine)
	{

		init(sSMPT_Server, sSMTPPort, sFromEmailAddress, sSMTPPassword, sToEmailAddresses, sSubject, sMessageText, sFileAttachments);

		// Let user specific path separator. (On Linux the path separator is /)
		this.sPathSeparator = sPathSeparator;
		this.sNewLine = sNewLine;
	}

	private void init(String sSMPT_Server, String sSMTPPort, String sFromEmailAddress, String sSMTPPassword, String[] sToEmailAddresses,
			String sSubject, String sMessageText, String[] sFileAttachments)
	{

		this.sSMPT_Server = sSMPT_Server;
		this.sSMTPPort = sSMTPPort;
		this.sFromEmailAddress = sFromEmailAddress;
		this.sSMTPPassword = sSMTPPassword;
		this.sToEmailAddresses = new String[sToEmailAddresses.length];
		System.arraycopy(sToEmailAddresses, 0, this.sToEmailAddresses, 0, sToEmailAddresses.length);
		this.sSubject = sSubject;
		this.sMessageText = sMessageText;
		this.sFileAttachments = new String[sFileAttachments.length];
		System.arraycopy(sFileAttachments, 0, this.sFileAttachments, 0, sFileAttachments.length);
	}

	@Override
	public String toString() {
		return "SendEmailDetails [sSMPT_Server=" + sSMPT_Server
				+ ", sFromEmailAddress=" + sFromEmailAddress
				+ ", sToEmailAddresses=" + Arrays.toString(sToEmailAddresses)
				+ ", sSubject=" + sSubject + ", sMessageText=" + sMessageText
				+ ", sFileAttachments=" + Arrays.toString(sFileAttachments)
				+ ", sPathSeparator=" + sPathSeparator + ", sNewLine="
				+ sNewLine + ", sSMTPPort=" + sSMTPPort + ", sSMTPPassword="
				+ sSMTPPassword + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(sFileAttachments);
		result = prime
				* result
				+ ((sFromEmailAddress == null) ? 0 : sFromEmailAddress
						.hashCode());
		result = prime * result
				+ ((sMessageText == null) ? 0 : sMessageText.hashCode());
		result = prime * result
				+ ((sNewLine == null) ? 0 : sNewLine.hashCode());
		result = prime * result
				+ ((sPathSeparator == null) ? 0 : sPathSeparator.hashCode());
		result = prime * result
				+ ((sSMPT_Server == null) ? 0 : sSMPT_Server.hashCode());
		result = prime * result
				+ ((sSMTPPassword == null) ? 0 : sSMTPPassword.hashCode());
		result = prime * result
				+ ((sSMTPPort == null) ? 0 : sSMTPPort.hashCode());
		result = prime * result
				+ ((sSubject == null) ? 0 : sSubject.hashCode());
		result = prime * result + Arrays.hashCode(sToEmailAddresses);
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
		SendEmailDetails other = (SendEmailDetails) obj;
		if (!Arrays.equals(sFileAttachments, other.sFileAttachments))
			return false;
		if (sFromEmailAddress == null) {
			if (other.sFromEmailAddress != null)
				return false;
		} else if (!sFromEmailAddress.equals(other.sFromEmailAddress))
			return false;
		if (sMessageText == null) {
			if (other.sMessageText != null)
				return false;
		} else if (!sMessageText.equals(other.sMessageText))
			return false;
		if (sNewLine == null) {
			if (other.sNewLine != null)
				return false;
		} else if (!sNewLine.equals(other.sNewLine))
			return false;
		if (sPathSeparator == null) {
			if (other.sPathSeparator != null)
				return false;
		} else if (!sPathSeparator.equals(other.sPathSeparator))
			return false;
		if (sSMPT_Server == null) {
			if (other.sSMPT_Server != null)
				return false;
		} else if (!sSMPT_Server.equals(other.sSMPT_Server))
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
		if (sSubject == null) {
			if (other.sSubject != null)
				return false;
		} else if (!sSubject.equals(other.sSubject))
			return false;
		if (!Arrays.equals(sToEmailAddresses, other.sToEmailAddresses))
			return false;
		return true;
	}
	
	
}
