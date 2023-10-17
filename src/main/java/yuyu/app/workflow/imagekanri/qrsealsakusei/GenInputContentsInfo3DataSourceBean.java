package yuyu.app.workflow.imagekanri.qrsealsakusei;

import java.io.Serializable;
import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * QRシール用紙作成 - inputContentsInfo3 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenInputContentsInfo3DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }


    private List<String> torikomiSyoruiCd;

    public List<String> getTorikomiSyoruiCd() {
        return torikomiSyoruiCd;
    }

    public void setTorikomiSyoruiCd(List<String> pTorikomiSyoruiCd) {
        torikomiSyoruiCd = pTorikomiSyoruiCd;
    }

    private LoopChain<UserDefsList> torikomiSyoruiCdOptionBeanList = new LoopChain<>();
    public UserDefsList getTorikomiSyoruiCdOptionBeanList() {
        return torikomiSyoruiCdOptionBeanList.get();
    }

    public void setTorikomiSyoruiCdOptionBeanList(UserDefsList pTorikomiSyoruiCdOptionBeanList) {
        torikomiSyoruiCdOptionBeanList.add(pTorikomiSyoruiCdOptionBeanList);
    }

    public void clearTorikomiSyoruiCdOptionBeanList() {
        torikomiSyoruiCdOptionBeanList.clear();
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }

}
