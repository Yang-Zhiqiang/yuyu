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
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.mapping.GenBM_ChkSueokiKikan;
import yuyu.def.db.meta.GenQBM_ChkSueokiKikan;
import yuyu.def.db.meta.QBM_ChkSueokiKikan;

/**
 * 据置期間チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSueokiKikan}</td><td colspan="3">据置期間チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSueokikkn sueokikkn}</td><td>据置期間</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSueokikknsmnkbn sueokikknsmnkbn}</td><td>据置期間歳満期区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SueokikknsmnKbn}</td></tr>
 * </table>
 * @see     BM_ChkSueokiKikan
 * @see     GenBM_ChkSueokiKikan
 * @see     QBM_ChkSueokiKikan
 * @see     GenQBM_ChkSueokiKikan
 */
public class PKBM_ChkSueokiKikan extends AbstractExDBPrimaryKey<BM_ChkSueokiKikan, PKBM_ChkSueokiKikan> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkSueokiKikan() {
    }

    public PKBM_ChkSueokiKikan(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pSueokikkn,
        C_SueokikknsmnKbn pSueokikknsmnkbn
    ) {
        syouhncd = pSyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        channelcd = pChannelcd;
        sueokikkn = pSueokikkn;
        sueokikknsmnkbn = pSueokikknsmnkbn;
    }

    @Transient
    @Override
    public Class<BM_ChkSueokiKikan> getEntityClass() {
        return BM_ChkSueokiKikan.class;
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
    private Integer sueokikkn;

    public Integer getSueokikkn() {
        return sueokikkn;
    }

    public void setSueokikkn(Integer pSueokikkn) {
        sueokikkn = pSueokikkn;
    }
    private C_SueokikknsmnKbn sueokikknsmnkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SueokikknsmnKbn")
    public C_SueokikknsmnKbn getSueokikknsmnkbn() {
        return sueokikknsmnkbn;
    }

    public void setSueokikknsmnkbn(C_SueokikknsmnKbn pSueokikknsmnkbn) {
        sueokikknsmnkbn = pSueokikknsmnkbn;
    }

}