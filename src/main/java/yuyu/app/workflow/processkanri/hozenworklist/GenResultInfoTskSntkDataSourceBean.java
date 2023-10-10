package yuyu.app.workflow.processkanri.hozenworklist;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全工程ワークリスト - resultInfoTskSntk の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenResultInfoTskSntkDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }


    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private String workflowTskNm;

    public String getWorkflowTskNm() {
        return workflowTskNm;
    }

    public void setWorkflowTskNm(String pWorkflowTskNm) {
        workflowTskNm = pWorkflowTskNm;
    }


    private BizNumber kjnTskKensuu;

    public BizNumber getKjnTskKensuu() {
        return kjnTskKensuu;
    }

    public void setKjnTskKensuu(BizNumber pKjnTskKensuu) {
        kjnTskKensuu = pKjnTskKensuu;
    }


    private String kojinNyuuryokuLink;

    public String getKojinNyuuryokuLink() {
        return kojinNyuuryokuLink;
    }

    public void setKojinNyuuryokuLink(String pKojinNyuuryokuLink) {
        kojinNyuuryokuLink = pKojinNyuuryokuLink;
    }


    private String kojinItiranLink;

    public String getKojinItiranLink() {
        return kojinItiranLink;
    }

    public void setKojinItiranLink(String pKojinItiranLink) {
        kojinItiranLink = pKojinItiranLink;
    }


    private BizNumber kyyTskKensuu;

    public BizNumber getKyyTskKensuu() {
        return kyyTskKensuu;
    }

    public void setKyyTskKensuu(BizNumber pKyyTskKensuu) {
        kyyTskKensuu = pKyyTskKensuu;
    }


    private String kyouyouNyuuryokuLink;

    public String getKyouyouNyuuryokuLink() {
        return kyouyouNyuuryokuLink;
    }

    public void setKyouyouNyuuryokuLink(String pKyouyouNyuuryokuLink) {
        kyouyouNyuuryokuLink = pKyouyouNyuuryokuLink;
    }


    private String kyouyouItiranLink;

    public String getKyouyouItiranLink() {
        return kyouyouItiranLink;
    }

    public void setKyouyouItiranLink(String pKyouyouItiranLink) {
        kyouyouItiranLink = pKyouyouItiranLink;
    }

}
