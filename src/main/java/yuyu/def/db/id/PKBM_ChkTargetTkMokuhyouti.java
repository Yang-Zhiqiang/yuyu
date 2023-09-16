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
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.mapping.GenBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.GenQBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;

/**
 * ターゲット特約目標値チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTargetTkMokuhyouti}</td><td colspan="3">ターゲット特約目標値チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_ChkTargetTkMokuhyouti
 * @see     GenBM_ChkTargetTkMokuhyouti
 * @see     QBM_ChkTargetTkMokuhyouti
 * @see     GenQBM_ChkTargetTkMokuhyouti
 */
public class PKBM_ChkTargetTkMokuhyouti extends AbstractExDBPrimaryKey<BM_ChkTargetTkMokuhyouti, PKBM_ChkTargetTkMokuhyouti> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkTargetTkMokuhyouti() {
    }

    public PKBM_ChkTargetTkMokuhyouti(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pTargettkmokuhyouti
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        channelcd = pChannelcd;
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    @Transient
    @Override
    public Class<BM_ChkTargetTkMokuhyouti> getEntityClass() {
        return BM_ChkTargetTkMokuhyouti.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
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
    private Integer targettkmokuhyouti;

    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

}