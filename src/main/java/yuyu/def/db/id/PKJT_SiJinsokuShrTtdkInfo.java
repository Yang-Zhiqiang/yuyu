package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.mapping.GenJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.GenQJT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.meta.QJT_SiJinsokuShrTtdkInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金迅速支払手続情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiJinsokuShrTtdkInfo}</td><td colspan="3">保険金給付金迅速支払手続情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHknknshrsntkno hknknshrsntkno}</td><td>保険金支払処理選択番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenymd denymd}</td><td>伝票日付</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruikeikaeigyoubisuu</td><td>書類受付経過営業日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syorikeikaeigyoubisuu</td><td>処理経過営業日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>toritugisosikicd</td><td>取次組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tanmatusyuruikbn</td><td>端末種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TanmatuSyuruiKbn C_TanmatuSyuruiKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiJinsokuShrTtdkInfo
 * @see     GenJT_SiJinsokuShrTtdkInfo
 * @see     QJT_SiJinsokuShrTtdkInfo
 * @see     GenQJT_SiJinsokuShrTtdkInfo
 */
public class PKJT_SiJinsokuShrTtdkInfo extends AbstractExDBPrimaryKey<JT_SiJinsokuShrTtdkInfo, PKJT_SiJinsokuShrTtdkInfo> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiJinsokuShrTtdkInfo() {
    }

    public PKJT_SiJinsokuShrTtdkInfo(
        String pSyorisosikicd,
        String pSyoricd,
        String pHknknshrsntkno,
        BizDate pSyoruiukeymd,
        BizDate pSyoriYmd,
        BizDate pDenymd,
        String pSyono
    ) {
        syorisosikicd = pSyorisosikicd;
        syoricd = pSyoricd;
        hknknshrsntkno = pHknknshrsntkno;
        syoruiukeymd = pSyoruiukeymd;
        syoriYmd = pSyoriYmd;
        denymd = pDenymd;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_SiJinsokuShrTtdkInfo> getEntityClass() {
        return JT_SiJinsokuShrTtdkInfo.class;
    }

    private String syorisosikicd;

    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }
    private String syoricd;

    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }
    private String hknknshrsntkno;

    public String getHknknshrsntkno() {
        return hknknshrsntkno;
    }

    public void setHknknshrsntkno(String pHknknshrsntkno) {
        hknknshrsntkno = pHknknshrsntkno;
    }
    private BizDate syoruiukeymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private BizDate denymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDenymd() {
        return denymd;
    }

    public void setDenymd(BizDate pDenymd) {
        denymd = pDenymd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}