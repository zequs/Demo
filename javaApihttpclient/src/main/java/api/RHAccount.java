package api;

import java.io.Serializable;
import java.math.BigDecimal;

public class RHAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Long id;
    private java.lang.String docid;
    private java.lang.String cashAccount;
    
    private String loginAccount;
    private String password;
    private String customeName;
    private String idCard;
    private Integer totalPositions;
    private BigDecimal totalPosCost;
    private Integer maximumWithdrawals;
    private BigDecimal appendMarginRate;
    private BigDecimal forceClose;
    private String middayForceClose;
    private String closedayForceClose;
    private String nightForceClose;
    private BigDecimal dayMaxLossNotice;
    private BigDecimal dayMaxLossForce;
    private BigDecimal overnightMaginRiskRate;
    private BigDecimal dayMaxLossNoticeRate;
    private BigDecimal dayMaxLossForceRate;
    private Integer marginSetting;
    private Integer commissionSetting;
    private Integer supportSHFEBigLegMargin;
    private Integer supportCFFEXBigLegMargin;
    private Integer overnightMagin;
    private Integer CloseOnly;
    
    
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.String getDocid() {
		return docid;
	}
	public void setDocid(java.lang.String docid) {
		this.docid = docid;
	}
	public java.lang.String getCashAccount() {
		return cashAccount;
	}
	public void setCashAccount(java.lang.String cashAccount) {
		this.cashAccount = cashAccount;
	}
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomeName() {
		return customeName;
	}
	public void setCustomeName(String customeName) {
		this.customeName = customeName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getTotalPositions() {
		return totalPositions;
	}
	public void setTotalPositions(Integer totalPositions) {
		this.totalPositions = totalPositions;
	}
	public BigDecimal getTotalPosCost() {
		return totalPosCost;
	}
	public void setTotalPosCost(BigDecimal totalPosCost) {
		this.totalPosCost = totalPosCost;
	}
	public Integer getMaximumWithdrawals() {
		return maximumWithdrawals;
	}
	public void setMaximumWithdrawals(Integer maximumWithdrawals) {
		this.maximumWithdrawals = maximumWithdrawals;
	}
	public BigDecimal getAppendMarginRate() {
		return appendMarginRate;
	}
	public void setAppendMarginRate(BigDecimal appendMarginRate) {
		this.appendMarginRate = appendMarginRate;
	}
	public BigDecimal getForceClose() {
		return forceClose;
	}
	public void setForceClose(BigDecimal forceClose) {
		this.forceClose = forceClose;
	}
	public String getMiddayForceClose() {
		return middayForceClose;
	}
	public void setMiddayForceClose(String middayForceClose) {
		this.middayForceClose = middayForceClose;
	}
	public String getClosedayForceClose() {
		return closedayForceClose;
	}
	public void setClosedayForceClose(String closedayForceClose) {
		this.closedayForceClose = closedayForceClose;
	}
	public String getNightForceClose() {
		return nightForceClose;
	}
	public void setNightForceClose(String nightForceClose) {
		this.nightForceClose = nightForceClose;
	}
	public BigDecimal getDayMaxLossNotice() {
		return dayMaxLossNotice;
	}
	public void setDayMaxLossNotice(BigDecimal dayMaxLossNotice) {
		this.dayMaxLossNotice = dayMaxLossNotice;
	}
	public BigDecimal getDayMaxLossForce() {
		return dayMaxLossForce;
	}
	public void setDayMaxLossForce(BigDecimal dayMaxLossForce) {
		this.dayMaxLossForce = dayMaxLossForce;
	}
	public BigDecimal getOvernightMaginRiskRate() {
		return overnightMaginRiskRate;
	}
	public void setOvernightMaginRiskRate(BigDecimal overnightMaginRiskRate) {
		this.overnightMaginRiskRate = overnightMaginRiskRate;
	}
	public BigDecimal getDayMaxLossNoticeRate() {
		return dayMaxLossNoticeRate;
	}
	public void setDayMaxLossNoticeRate(BigDecimal dayMaxLossNoticeRate) {
		this.dayMaxLossNoticeRate = dayMaxLossNoticeRate;
	}
	public BigDecimal getDayMaxLossForceRate() {
		return dayMaxLossForceRate;
	}
	public void setDayMaxLossForceRate(BigDecimal dayMaxLossForceRate) {
		this.dayMaxLossForceRate = dayMaxLossForceRate;
	}
	public Integer getMarginSetting() {
		return marginSetting;
	}
	public void setMarginSetting(Integer marginSetting) {
		this.marginSetting = marginSetting;
	}
	public Integer getCommissionSetting() {
		return commissionSetting;
	}
	public void setCommissionSetting(Integer commissionSetting) {
		this.commissionSetting = commissionSetting;
	}
	public Integer getSupportSHFEBigLegMargin() {
		return supportSHFEBigLegMargin;
	}
	public void setSupportSHFEBigLegMargin(Integer supportSHFEBigLegMargin) {
		this.supportSHFEBigLegMargin = supportSHFEBigLegMargin;
	}
	public Integer getSupportCFFEXBigLegMargin() {
		return supportCFFEXBigLegMargin;
	}
	public void setSupportCFFEXBigLegMargin(Integer supportCFFEXBigLegMargin) {
		this.supportCFFEXBigLegMargin = supportCFFEXBigLegMargin;
	}
	public Integer getOvernightMagin() {
		return overnightMagin;
	}
	public void setOvernightMagin(Integer overnightMagin) {
		this.overnightMagin = overnightMagin;
	}
	public Integer getCloseOnly() {
		return CloseOnly;
	}
	public void setCloseOnly(Integer closeOnly) {
		CloseOnly = closeOnly;
	}
	@Override
	public String toString() {
		return "RHAccount [id=" + id + ", docid=" + docid + ", cashAccount="
				+ cashAccount + ", loginAccount=" + loginAccount
				+ ", password=" + password + ", customeName=" + customeName
				+ ", idCard=" + idCard + ", totalPositions=" + totalPositions
				+ ", totalPosCost=" + totalPosCost + ", maximumWithdrawals="
				+ maximumWithdrawals + ", appendMarginRate=" + appendMarginRate
				+ ", forceClose=" + forceClose + ", middayForceClose="
				+ middayForceClose + ", closedayForceClose="
				+ closedayForceClose + ", nightForceClose=" + nightForceClose
				+ ", dayMaxLossNotice=" + dayMaxLossNotice
				+ ", dayMaxLossForce=" + dayMaxLossForce
				+ ", overnightMaginRiskRate=" + overnightMaginRiskRate
				+ ", dayMaxLossNoticeRate=" + dayMaxLossNoticeRate
				+ ", dayMaxLossForceRate=" + dayMaxLossForceRate
				+ ", marginSetting=" + marginSetting + ", commissionSetting="
				+ commissionSetting + ", supportSHFEBigLegMargin="
				+ supportSHFEBigLegMargin + ", supportCFFEXBigLegMargin="
				+ supportCFFEXBigLegMargin + ", overnightMagin="
				+ overnightMagin + ", CloseOnly=" + CloseOnly + "]";
	}

    
}
