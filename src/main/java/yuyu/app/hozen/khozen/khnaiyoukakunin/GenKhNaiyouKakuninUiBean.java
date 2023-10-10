package yuyu.app.hozen.khozen.khnaiyoukakunin;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_KakuninkekkaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全内容確認 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenKhNaiyouKakuninUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<JyouhouListDataSourceBean> jyouhouListDataSource = new DataSource<>();
    public DataSource<JyouhouListDataSourceBean> getJyouhouListDataSource() {
        return jyouhouListDataSource;
    }

    @Deprecated
    public List<JyouhouListDataSourceBean> getJyouhouList() {
        return jyouhouListDataSource.getDatas();
    }

    public void setJyouhouList(List<JyouhouListDataSourceBean> pJyouhouList) {
        jyouhouListDataSource.setDatas(pJyouhouList);
    }

    private DataSource<SyoruiInfoListDataSourceBean> syoruiInfoListDataSource = new DataSource<>();
    public DataSource<SyoruiInfoListDataSourceBean> getSyoruiInfoListDataSource() {
        return syoruiInfoListDataSource;
    }

    @Deprecated
    public List<SyoruiInfoListDataSourceBean> getSyoruiInfoList() {
        return syoruiInfoListDataSource.getDatas();
    }

    public void setSyoruiInfoList(List<SyoruiInfoListDataSourceBean> pSyoruiInfoList) {
        syoruiInfoListDataSource.setDatas(pSyoruiInfoList);
    }

    private DataSource<KakuninKekkaInfoDataSourceBean> kakuninKekkaInfoDataSource = new DataSource<>();
    public DataSource<KakuninKekkaInfoDataSourceBean> getKakuninKekkaInfoDataSource() {
        return kakuninKekkaInfoDataSource;
    }

    @Deprecated
    public List<KakuninKekkaInfoDataSourceBean> getKakuninKekkaInfo() {
        return kakuninKekkaInfoDataSource.getDatas();
    }

    public void setKakuninKekkaInfo(List<KakuninKekkaInfoDataSourceBean> pKakuninKekkaInfo) {
        kakuninKekkaInfoDataSource.setDatas(pKakuninKekkaInfo);
    }

    private String jimuttdknm;

    public String getJimuttdknm() {
        return jimuttdknm;
    }

    public void setJimuttdknm(String pJimuttdknm) {
        jimuttdknm = pJimuttdknm;
    }

    private String kinoussnm;

    public String getKinoussnm() {
        return kinoussnm;
    }

    public void setKinoussnm(String pKinoussnm) {
        kinoussnm = pKinoussnm;
    }

    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate jimustartymd;

    public BizDate getJimustartymd() {
        return jimustartymd;
    }

    public void setJimustartymd(BizDate pJimustartymd) {
        jimustartymd = pJimustartymd;
    }

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private C_KakuninkekkaKbn kakuninkekkakbn;

    public C_KakuninkekkaKbn getKakuninkekkakbn() {
        return kakuninkekkakbn;
    }

    public void setKakuninkekkakbn(C_KakuninkekkaKbn pKakuninkekkakbn) {
        kakuninkekkakbn = pKakuninkekkakbn;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String commentgamen;

    public String getCommentgamen() {
        return commentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setCommentgamen(String pCommentgamen) {
        commentgamen = pCommentgamen;
    }
}
