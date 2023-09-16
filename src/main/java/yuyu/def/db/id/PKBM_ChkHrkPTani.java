package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkHrkPTani;
import yuyu.def.db.mapping.GenBM_ChkHrkPTani;
import yuyu.def.db.meta.GenQBM_ChkHrkPTani;
import yuyu.def.db.meta.QBM_ChkHrkPTani;

/**
 * 払込Ｐ単位チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkHrkPTani}</td><td colspan="3">払込Ｐ単位チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">○</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>hrkptani</td><td>払込Ｐ単位</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BM_ChkHrkPTani
 * @see     GenBM_ChkHrkPTani
 * @see     QBM_ChkHrkPTani
 * @see     GenQBM_ChkHrkPTani
 */
public class PKBM_ChkHrkPTani extends AbstractExDBPrimaryKey<BM_ChkHrkPTani, PKBM_ChkHrkPTani> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkHrkPTani() {
    }

    public PKBM_ChkHrkPTani(
        String pSyouhncd,
        C_Hrkkaisuu pHrkkaisuu,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        C_Tuukasyu pHrktuukasyu
    ) {
        syouhncd = pSyouhncd;
        hrkkaisuu = pHrkkaisuu;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        channelcd = pChannelcd;
        hrktuukasyu = pHrktuukasyu;
    }

    @Transient
    @Override
    public Class<BM_ChkHrkPTani> getEntityClass() {
        return BM_ChkHrkPTani.class;
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
    private C_Tuukasyu hrktuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

}