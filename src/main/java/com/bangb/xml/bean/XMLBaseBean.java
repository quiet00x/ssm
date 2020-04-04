package com.bangb.xml.bean;

public class XMLBaseBean {
	private String RequesterId;
	private String ResponderId;
	private String ESBServiceId;
	private String MessageType;
	private String ESBReqTimestamp;
	private String ESBRspTimestamp;
	private String Version;
	private String ReservedHead;
	private String TradeCode;
	private String ReqSerialNo;
	private String TradeDate;
	private String TradeTime;
	private String ReservedBody;
	private String EnterpriseId;
	private String TradeChannel;
	private String SubBankNo;
	private String OrganNo;
	private String TellerNo;
	private String TermNo;
	private String ForeTradeCode;
	private String TradeNote;
	private String AuthLevel;
	private String Supervisor1;
	private String Supervisor2;
	private String Supv1Password;
	private String Supv2Password;
	private String AuthReason;
	private String RequestLevel;
	private String TotalSize;
	private String EventId;
	private String EventType;
	public String getRequesterId() {
		return RequesterId;
	}
	public void setRequesterId(String requesterId) {
		RequesterId = requesterId;
	}
	public String getResponderId() {
		return ResponderId;
	}
	public void setResponderId(String responderId) {
		ResponderId = responderId;
	}
	public String getESBServiceId() {
		return ESBServiceId;
	}
	public void setESBServiceId(String eSBServiceId) {
		ESBServiceId = eSBServiceId;
	}
	public String getMessageType() {
		return MessageType;
	}
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}
	public String getESBReqTimestamp() {
		return ESBReqTimestamp;
	}
	public void setESBReqTimestamp(String eSBReqTimestamp) {
		ESBReqTimestamp = eSBReqTimestamp;
	}
	public String getESBRspTimestamp() {
		return ESBRspTimestamp;
	}
	public void setESBRspTimestamp(String eSBRspTimestamp) {
		ESBRspTimestamp = eSBRspTimestamp;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getReservedHead() {
		return ReservedHead;
	}
	public void setReservedHead(String reservedHead) {
		ReservedHead = reservedHead;
	}
	public String getTradeCode() {
		return TradeCode;
	}
	public void setTradeCode(String tradeCode) {
		TradeCode = tradeCode;
	}
	public String getReqSerialNo() {
		return ReqSerialNo;
	}
	public void setReqSerialNo(String reqSerialNo) {
		ReqSerialNo = reqSerialNo;
	}
	public String getTradeDate() {
		return TradeDate;
	}
	public void setTradeDate(String tradeDate) {
		TradeDate = tradeDate;
	}
	public String getTradeTime() {
		return TradeTime;
	}
	public void setTradeTime(String tradeTime) {
		TradeTime = tradeTime;
	}
	public String getReservedBody() {
		return ReservedBody;
	}
	public void setReservedBody(String reservedBody) {
		ReservedBody = reservedBody;
	}
	public String getEnterpriseId() {
		return EnterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		EnterpriseId = enterpriseId;
	}
	public String getTradeChannel() {
		return TradeChannel;
	}
	public void setTradeChannel(String tradeChannel) {
		TradeChannel = tradeChannel;
	}
	public String getSubBankNo() {
		return SubBankNo;
	}
	public void setSubBankNo(String subBankNo) {
		SubBankNo = subBankNo;
	}
	public String getOrganNo() {
		return OrganNo;
	}
	public void setOrganNo(String organNo) {
		OrganNo = organNo;
	}
	public String getTellerNo() {
		return TellerNo;
	}
	public void setTellerNo(String tellerNo) {
		TellerNo = tellerNo;
	}
	public String getTermNo() {
		return TermNo;
	}
	public void setTermNo(String termNo) {
		TermNo = termNo;
	}
	public String getForeTradeCode() {
		return ForeTradeCode;
	}
	public void setForeTradeCode(String foreTradeCode) {
		ForeTradeCode = foreTradeCode;
	}
	public String getTradeNote() {
		return TradeNote;
	}
	public void setTradeNote(String tradeNote) {
		TradeNote = tradeNote;
	}
	public String getAuthLevel() {
		return AuthLevel;
	}
	public void setAuthLevel(String authLevel) {
		AuthLevel = authLevel;
	}
	public String getSupervisor1() {
		return Supervisor1;
	}
	public void setSupervisor1(String supervisor1) {
		Supervisor1 = supervisor1;
	}
	public String getSupervisor2() {
		return Supervisor2;
	}
	public void setSupervisor2(String supervisor2) {
		Supervisor2 = supervisor2;
	}
	public String getSupv1Password() {
		return Supv1Password;
	}
	public void setSupv1Password(String supv1Password) {
		Supv1Password = supv1Password;
	}
	public String getSupv2Password() {
		return Supv2Password;
	}
	public void setSupv2Password(String supv2Password) {
		Supv2Password = supv2Password;
	}
	public String getAuthReason() {
		return AuthReason;
	}
	public void setAuthReason(String authReason) {
		AuthReason = authReason;
	}
	public String getRequestLevel() {
		return RequestLevel;
	}
	public void setRequestLevel(String requestLevel) {
		RequestLevel = requestLevel;
	}
	public String getTotalSize() {
		return TotalSize;
	}
	public void setTotalSize(String totalSize) {
		TotalSize = totalSize;
	}
	public String getEventId() {
		return EventId;
	}
	public void setEventId(String eventId) {
		EventId = eventId;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AuthLevel == null) ? 0 : AuthLevel.hashCode());
		result = prime * result + ((AuthReason == null) ? 0 : AuthReason.hashCode());
		result = prime * result + ((ESBReqTimestamp == null) ? 0 : ESBReqTimestamp.hashCode());
		result = prime * result + ((ESBRspTimestamp == null) ? 0 : ESBRspTimestamp.hashCode());
		result = prime * result + ((ESBServiceId == null) ? 0 : ESBServiceId.hashCode());
		result = prime * result + ((EnterpriseId == null) ? 0 : EnterpriseId.hashCode());
		result = prime * result + ((EventId == null) ? 0 : EventId.hashCode());
		result = prime * result + ((EventType == null) ? 0 : EventType.hashCode());
		result = prime * result + ((ForeTradeCode == null) ? 0 : ForeTradeCode.hashCode());
		result = prime * result + ((MessageType == null) ? 0 : MessageType.hashCode());
		result = prime * result + ((OrganNo == null) ? 0 : OrganNo.hashCode());
		result = prime * result + ((ReqSerialNo == null) ? 0 : ReqSerialNo.hashCode());
		result = prime * result + ((RequestLevel == null) ? 0 : RequestLevel.hashCode());
		result = prime * result + ((RequesterId == null) ? 0 : RequesterId.hashCode());
		result = prime * result + ((ReservedBody == null) ? 0 : ReservedBody.hashCode());
		result = prime * result + ((ReservedHead == null) ? 0 : ReservedHead.hashCode());
		result = prime * result + ((ResponderId == null) ? 0 : ResponderId.hashCode());
		result = prime * result + ((SubBankNo == null) ? 0 : SubBankNo.hashCode());
		result = prime * result + ((Supervisor1 == null) ? 0 : Supervisor1.hashCode());
		result = prime * result + ((Supervisor2 == null) ? 0 : Supervisor2.hashCode());
		result = prime * result + ((Supv1Password == null) ? 0 : Supv1Password.hashCode());
		result = prime * result + ((Supv2Password == null) ? 0 : Supv2Password.hashCode());
		result = prime * result + ((TellerNo == null) ? 0 : TellerNo.hashCode());
		result = prime * result + ((TermNo == null) ? 0 : TermNo.hashCode());
		result = prime * result + ((TotalSize == null) ? 0 : TotalSize.hashCode());
		result = prime * result + ((TradeChannel == null) ? 0 : TradeChannel.hashCode());
		result = prime * result + ((TradeCode == null) ? 0 : TradeCode.hashCode());
		result = prime * result + ((TradeDate == null) ? 0 : TradeDate.hashCode());
		result = prime * result + ((TradeNote == null) ? 0 : TradeNote.hashCode());
		result = prime * result + ((TradeTime == null) ? 0 : TradeTime.hashCode());
		result = prime * result + ((Version == null) ? 0 : Version.hashCode());
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
		XMLBaseBean other = (XMLBaseBean) obj;
		if (AuthLevel == null) {
			if (other.AuthLevel != null)
				return false;
		} else if (!AuthLevel.equals(other.AuthLevel))
			return false;
		if (AuthReason == null) {
			if (other.AuthReason != null)
				return false;
		} else if (!AuthReason.equals(other.AuthReason))
			return false;
		if (ESBReqTimestamp == null) {
			if (other.ESBReqTimestamp != null)
				return false;
		} else if (!ESBReqTimestamp.equals(other.ESBReqTimestamp))
			return false;
		if (ESBRspTimestamp == null) {
			if (other.ESBRspTimestamp != null)
				return false;
		} else if (!ESBRspTimestamp.equals(other.ESBRspTimestamp))
			return false;
		if (ESBServiceId == null) {
			if (other.ESBServiceId != null)
				return false;
		} else if (!ESBServiceId.equals(other.ESBServiceId))
			return false;
		if (EnterpriseId == null) {
			if (other.EnterpriseId != null)
				return false;
		} else if (!EnterpriseId.equals(other.EnterpriseId))
			return false;
		if (EventId == null) {
			if (other.EventId != null)
				return false;
		} else if (!EventId.equals(other.EventId))
			return false;
		if (EventType == null) {
			if (other.EventType != null)
				return false;
		} else if (!EventType.equals(other.EventType))
			return false;
		if (ForeTradeCode == null) {
			if (other.ForeTradeCode != null)
				return false;
		} else if (!ForeTradeCode.equals(other.ForeTradeCode))
			return false;
		if (MessageType == null) {
			if (other.MessageType != null)
				return false;
		} else if (!MessageType.equals(other.MessageType))
			return false;
		if (OrganNo == null) {
			if (other.OrganNo != null)
				return false;
		} else if (!OrganNo.equals(other.OrganNo))
			return false;
		if (ReqSerialNo == null) {
			if (other.ReqSerialNo != null)
				return false;
		} else if (!ReqSerialNo.equals(other.ReqSerialNo))
			return false;
		if (RequestLevel == null) {
			if (other.RequestLevel != null)
				return false;
		} else if (!RequestLevel.equals(other.RequestLevel))
			return false;
		if (RequesterId == null) {
			if (other.RequesterId != null)
				return false;
		} else if (!RequesterId.equals(other.RequesterId))
			return false;
		if (ReservedBody == null) {
			if (other.ReservedBody != null)
				return false;
		} else if (!ReservedBody.equals(other.ReservedBody))
			return false;
		if (ReservedHead == null) {
			if (other.ReservedHead != null)
				return false;
		} else if (!ReservedHead.equals(other.ReservedHead))
			return false;
		if (ResponderId == null) {
			if (other.ResponderId != null)
				return false;
		} else if (!ResponderId.equals(other.ResponderId))
			return false;
		if (SubBankNo == null) {
			if (other.SubBankNo != null)
				return false;
		} else if (!SubBankNo.equals(other.SubBankNo))
			return false;
		if (Supervisor1 == null) {
			if (other.Supervisor1 != null)
				return false;
		} else if (!Supervisor1.equals(other.Supervisor1))
			return false;
		if (Supervisor2 == null) {
			if (other.Supervisor2 != null)
				return false;
		} else if (!Supervisor2.equals(other.Supervisor2))
			return false;
		if (Supv1Password == null) {
			if (other.Supv1Password != null)
				return false;
		} else if (!Supv1Password.equals(other.Supv1Password))
			return false;
		if (Supv2Password == null) {
			if (other.Supv2Password != null)
				return false;
		} else if (!Supv2Password.equals(other.Supv2Password))
			return false;
		if (TellerNo == null) {
			if (other.TellerNo != null)
				return false;
		} else if (!TellerNo.equals(other.TellerNo))
			return false;
		if (TermNo == null) {
			if (other.TermNo != null)
				return false;
		} else if (!TermNo.equals(other.TermNo))
			return false;
		if (TotalSize == null) {
			if (other.TotalSize != null)
				return false;
		} else if (!TotalSize.equals(other.TotalSize))
			return false;
		if (TradeChannel == null) {
			if (other.TradeChannel != null)
				return false;
		} else if (!TradeChannel.equals(other.TradeChannel))
			return false;
		if (TradeCode == null) {
			if (other.TradeCode != null)
				return false;
		} else if (!TradeCode.equals(other.TradeCode))
			return false;
		if (TradeDate == null) {
			if (other.TradeDate != null)
				return false;
		} else if (!TradeDate.equals(other.TradeDate))
			return false;
		if (TradeNote == null) {
			if (other.TradeNote != null)
				return false;
		} else if (!TradeNote.equals(other.TradeNote))
			return false;
		if (TradeTime == null) {
			if (other.TradeTime != null)
				return false;
		} else if (!TradeTime.equals(other.TradeTime))
			return false;
		if (Version == null) {
			if (other.Version != null)
				return false;
		} else if (!Version.equals(other.Version))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "XMLBaseBean [RequesterId=" + RequesterId + ", ResponderId=" + ResponderId + ", ESBServiceId="
				+ ESBServiceId + ", MessageType=" + MessageType + ", ESBReqTimestamp=" + ESBReqTimestamp
				+ ", ESBRspTimestamp=" + ESBRspTimestamp + ", Version=" + Version + ", ReservedHead=" + ReservedHead
				+ ", TradeCode=" + TradeCode + ", ReqSerialNo=" + ReqSerialNo + ", TradeDate=" + TradeDate
				+ ", TradeTime=" + TradeTime + ", ReservedBody=" + ReservedBody + ", EnterpriseId=" + EnterpriseId
				+ ", TradeChannel=" + TradeChannel + ", SubBankNo=" + SubBankNo + ", OrganNo=" + OrganNo + ", TellerNo="
				+ TellerNo + ", TermNo=" + TermNo + ", ForeTradeCode=" + ForeTradeCode + ", TradeNote=" + TradeNote
				+ ", AuthLevel=" + AuthLevel + ", Supervisor1=" + Supervisor1 + ", Supervisor2=" + Supervisor2
				+ ", Supv1Password=" + Supv1Password + ", Supv2Password=" + Supv2Password + ", AuthReason=" + AuthReason
				+ ", RequestLevel=" + RequestLevel + ", TotalSize=" + TotalSize + ", EventId=" + EventId
				+ ", EventType=" + EventType + "]";
	}
	
}
