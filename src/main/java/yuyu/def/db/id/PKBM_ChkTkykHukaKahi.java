package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.mapping.GenBM_ChkTkykHukaKahi;
import yuyu.def.db.meta.GenQBM_ChkTkykHukaKahi;
import yuyu.def.db.meta.QBM_ChkTkykHukaKahi;

/**
 * 特約付加可否倍率チェックマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykHukaKahi}</td><td colspan="3">特約付加可否倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>hukakahikbn</td><td>付加可否区分</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkbairituhugou</td><td>特約倍率符号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkbairitu</td><td>特約倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tkhukahissuumu</td><td>特約付加必須有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     BM_ChkTkykHukaKahi
 * @see     GenBM_ChkTkykHukaKahi
 * @see     QBM_ChkTkykHukaKahi
 * @see     GenQBM_ChkTkykHukaKahi
 */
public class PKBM_ChkTkykHukaKahi extends AbstractExDBPrimaryKey<BM_ChkTkykHukaKahi, PKBM_ChkTkykHukaKahi> {

    private static final long serialVersionUID = 1L;

    public PKBM_ChkTkykHukaKahi() {
    }

    public PKBM_ChkTkykHukaKahi(
        String pTksyouhncd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd
    ) {
        tksyouhncd = pTksyouhncd;
        syusyouhncd = pSyusyouhncd;
        syusyouhnsdnofrom = pSyusyouhnsdnofrom;
        syusyouhnsdnoto = pSyusyouhnsdnoto;
        channelcd = pChannelcd;
    }

    @Transient
    @Override
    public Class<BM_ChkTkykHukaKahi> getEntityClass() {
        return BM_ChkTkykHukaKahi.class;
    }

    private String tksyouhncd;

    public String getTksyouhncd() {
        return tksyouhncd;
    }

    public void setTksyouhncd(String pTksyouhncd) {
        tksyouhncd = pTksyouhncd;
    }
    private String syusyouhncd;

    public String getSyusyouhncd() {
        return syusyouhncd;
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        syusyouhncd = pSyusyouhncd;
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

}