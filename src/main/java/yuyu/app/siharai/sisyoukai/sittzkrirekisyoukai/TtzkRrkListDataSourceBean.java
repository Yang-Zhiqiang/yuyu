package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import yuyu.def.classification.C_SibouKariUketukeSyoriKbn;

/**
 * 手続履歴照会 - ttzkRrkList の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class TtzkRrkListDataSourceBean extends GenTtzkRrkListDataSourceBean {

    private static final long serialVersionUID = 1L;

    public TtzkRrkListDataSourceBean() {
    }

    private String kinouId;

    private String kinouModeId;

    private Integer seiRrkNo;

    private C_SibouKariUketukeSyoriKbn sibouKariUketukeSyoriKbn;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    public String getKinouModeId() {
        return kinouModeId;
    }

    public void setKinouModeId(String pKinouModeId) {
        kinouModeId = pKinouModeId;
    }

    public Integer getSeiRrkNo() {
        return seiRrkNo;
    }

    public void setSeiRrkNo(Integer pSeiRrkNo) {
        seiRrkNo = pSeiRrkNo;
    }

    public C_SibouKariUketukeSyoriKbn getSibouKariUketukeSyoriKbn() {
        return sibouKariUketukeSyoriKbn;
    }

    public void setSibouKariUketukeSyoriKbn(C_SibouKariUketukeSyoriKbn pSibouKariUketukeSyoriKbn) {
        sibouKariUketukeSyoriKbn = pSibouKariUketukeSyoriKbn;
    }
}