package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaiteiP;
import yuyu.def.db.mapping.GenBM_ChkSaiteiP;
import yuyu.def.db.meta.GenQBM_ChkSaiteiP;
import yuyu.def.db.meta.QBM_ChkSaiteiP;

/**
 * 最低Ｐチェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSaiteiP}</td><td colspan="3">最低Ｐチェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">○</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkknfrom hrkkknfrom}</td><td>払込期間自</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkknto hrkkknto}</td><td>払込期間至</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhinbetukey1 syouhinbetukey1}</td><td>商品別キー１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saiteip</td><td>最低Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ptani</td><td>Ｐ単位</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkSaiteiP
 * @see     GenBM_ChkSaiteiP
 * @see     QBM_ChkSaiteiP
 * @see     GenQBM_ChkSaiteiP
 */
public class PKBM_ChkSaiteiP extends AbstractExDBPrimaryKey<BM_ChkSaiteiP, PKBM_ChkSaiteiP> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkSaiteiP() {
    }

    public PKBM_ChkSaiteiP(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        BizNumber pHrkkknfrom,
        BizNumber pHrkkknto,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pTuukasyu,
        String pSyouhinbetukey1
    ) {
        syouhncd = pSyouhncd;
        hrkkaisuu = pHrkkaisuu;
        hrkkknfrom = pHrkkknfrom;
        hrkkknto = pHrkkknto;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        channelcd = pChannelcd;
        tuukasyu = pTuukasyu;
        syouhinbetukey1 = pSyouhinbetukey1;
    }

    @Transient
    @Override
    public Class<BM_ChkSaiteiP> getEntityClass() {
        return BM_ChkSaiteiP.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private C_Hrkkaisuu hrkkaisuu;

    @org.hibernate.annotations.Type(type="UserType_C_Hrkkaisuu")
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }
    private BizNumber hrkkknfrom;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHrkkknfrom() {
        return hrkkknfrom;
    }

    public void setHrkkknfrom(BizNumber pHrkkknfrom) {
        hrkkknfrom = pHrkkknfrom;
    }
    private BizNumber hrkkknto;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getHrkkknto() {
        return hrkkknto;
    }

    public void setHrkkknto(BizNumber pHrkkknto) {
        hrkkknto = pHrkkknto;
    }
    private Integer syusyouhnsdnofrom;

    public Integer getSyusyouhnsdnofrom() {
        return syusyouhnsdnofrom;
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
    }
    private Integer syusyouhnsdnoto;

    public Integer getSyusyouhnsdnoto() {
        return syusyouhnsdnoto;
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        syusyouhnsdnoto = pSyusyouhnsdnoto;
    }
    private C_Channelcd channelcd;

    @org.hibernate.annotations.Type(type="UserType_C_Channelcd")
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private String syouhinbetukey1;

    public String getSyouhinbetukey1() {
        return syouhinbetukey1;
    }

    public void setSyouhinbetukey1(String pSyouhinbetukey1) {
        syouhinbetukey1 = pSyouhinbetukey1;
    }

}