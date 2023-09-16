package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.db.entity.HT_Houjyou;
import yuyu.def.db.mapping.GenHT_Houjyou;
import yuyu.def.db.meta.GenQHT_Houjyou;
import yuyu.def.db.meta.QHT_Houjyou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 報状テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Houjyou}</td><td colspan="3">報状テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyosaikbn syosaikbn}</td><td>初診再診区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyosaiKbn}</td></tr>
 *  <tr><td>sinsakbn</td><td>診査区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaKbn C_SinsaKbn}</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sintyou</td><td>身長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>taijyuu</td><td>体重</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kituenkbn</td><td>喫煙区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KituenKbn C_KituenKbn}</td></tr>
 *  <tr><td>kituenhon</td><td>喫煙本数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sinsaicd</td><td>診査医コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinsaymd</td><td>診査日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sinsatime</td><td>診査時刻</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sinsatime C_Sinsatime}</td></tr>
 *  <tr><td>takuoukbn</td><td>宅診往診区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TakuouKbn C_TakuouKbn}</td></tr>
 *  <tr><td>sinsabakbn</td><td>診査場所区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsabaKbn C_SinsabaKbn}</td></tr>
 *  <tr><td>hbcmnt</td><td>不備コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Houjyou
 * @see     GenHT_Houjyou
 * @see     QHT_Houjyou
 * @see     GenQHT_Houjyou
 */
public class PKHT_Houjyou extends AbstractExDBPrimaryKey<HT_Houjyou, PKHT_Houjyou> {

    private static final long serialVersionUID = 1L;

    public PKHT_Houjyou() {
    }

    public PKHT_Houjyou(String pMosno, C_SyosaiKbn pSyosaikbn) {
        mosno = pMosno;
        syosaikbn = pSyosaikbn;
    }

    @Transient
    @Override
    public Class<HT_Houjyou> getEntityClass() {
        return HT_Houjyou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_SyosaiKbn syosaikbn;

    @org.hibernate.annotations.Type(type="UserType_C_SyosaiKbn")
    public C_SyosaiKbn getSyosaikbn() {
        return syosaikbn;
    }

    public void setSyosaikbn(C_SyosaiKbn pSyosaikbn) {
        syosaikbn = pSyosaikbn;
    }

}