package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入力差異照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkNyuuryokuSaiSyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<NyuuryokuSouiListDataSourceBean> nyuuryokuSouiListDataSource = new DataSource<>();
    public DataSource<NyuuryokuSouiListDataSourceBean> getNyuuryokuSouiListDataSource() {
        return nyuuryokuSouiListDataSource;
    }

    @Deprecated
    public List<NyuuryokuSouiListDataSourceBean> getNyuuryokuSouiList() {
        return nyuuryokuSouiListDataSource.getDatas();
    }

    public void setNyuuryokuSouiList(List<NyuuryokuSouiListDataSourceBean> pNyuuryokuSouiList) {
        nyuuryokuSouiListDataSource.setDatas(pNyuuryokuSouiList);
    }

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

    @MousikomiNo
    private String aitemosno;

    public String getAitemosno() {
        return aitemosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
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

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
