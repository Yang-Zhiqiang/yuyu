package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IT_ZennouKessan;
import yuyu.def.db.mapping.GenIT_ZennouKessan;
import yuyu.def.db.meta.GenQIT_ZennouKessan;
import yuyu.def.db.meta.QIT_ZennouKessan;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納決算テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ZennouKessan}</td><td colspan="3">前納決算テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ZennouKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_ZennouToukeiListKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoustartym zennoustartym}</td><td>前納開始年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>zennoukaisiymd</td><td>前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoukaisijizndk</td><td>前納開始時残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>keiyakuymd</td><td>契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennouwrbkrt</td><td>前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rthndzndk1</td><td>利率変動時残高１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkyrt1</td><td>適用利率１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rthndymd1</td><td>利率変動年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rthndzndk2</td><td>利率変動時残高２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkyrt2</td><td>適用利率２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rthndymd2</td><td>利率変動年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rthndzndk3</td><td>利率変動時残高３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkyrt3</td><td>適用利率３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rthndymd3</td><td>利率変動年月日３</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>rthndzndk4</td><td>利率変動時残高４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkyrt4</td><td>適用利率４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rthndymd4</td><td>利率変動年月日４</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tndmatuzndk</td><td>当年度末残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tndmatutkyrt</td><td>当年度末適用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zennounyuukinymd</td><td>前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tndzndkhikakukbn</td><td>当年度残高比較区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennoukikan</td><td>前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobi01xv1</td><td>予備０１＿Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuukeitaikbn</td><td>募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yobi02xv11</td><td>予備０２＿Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gkdtznnhyj</td><td>外貨建前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>znngaikakbn</td><td>前納外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yenkanyknhyj</td><td>円貨入金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>znnnyknjikawaserate</td><td>前納入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>znnnyknjikawaseratetkyuymd</td><td>前納入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ksnkisikawaserate</td><td>決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tndmatuzndkksnjkwsrate</td><td>当年度末残高計算時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zennounyuukinkgkgaika</td><td>前納入金額＿外貨</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennounyuukinkgktkmatu</td><td>前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennoukaisijizndktkmatu</td><td>前納開始時残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rthndzndk1tkmatu</td><td>利率変動時残高１＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rthndzndk2tkmatu</td><td>利率変動時残高２＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rthndzndk3tkmatu</td><td>利率変動時残高３＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rthndzndk4tkmatu</td><td>利率変動時残高４＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tndmatuzndktkmatu</td><td>当年度末残高＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ZennouKessan
 * @see     GenIT_ZennouKessan
 * @see     QIT_ZennouKessan
 * @see     GenQIT_ZennouKessan
 */
public class PKIT_ZennouKessan extends AbstractExDBPrimaryKey<IT_ZennouKessan, PKIT_ZennouKessan> {

    private static final long serialVersionUID = 1L;

    public PKIT_ZennouKessan() {
    }

    public PKIT_ZennouKessan(
        String pKbnkey,
        String pSyono,
        BizDate pSakuseiymd,
        C_Segcd pKbnkeirisegcd,
        C_ZennouKbn pZennoukbn,
        C_ZennouToukeiListKbn pZennoutoukeilistkbn,
        BizDateYM pZennoustartym
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        sakuseiymd = pSakuseiymd;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoukbn = pZennoukbn;
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoustartym = pZennoustartym;
    }

    @Transient
    @Override
    public Class<IT_ZennouKessan> getEntityClass() {
        return IT_ZennouKessan.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate sakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSakuseiymd() {
        return sakuseiymd;
    }

    public void setSakuseiymd(BizDate pSakuseiymd) {
        sakuseiymd = pSakuseiymd;
    }
    private C_Segcd kbnkeirisegcd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }
    private C_ZennouKbn zennoukbn;

    @org.hibernate.annotations.Type(type="UserType_C_ZennouKbn")
    public C_ZennouKbn getZennoukbn() {
        return zennoukbn;
    }

    public void setZennoukbn(C_ZennouKbn pZennoukbn) {
        zennoukbn = pZennoukbn;
    }
    private C_ZennouToukeiListKbn zennoutoukeilistkbn;

    @org.hibernate.annotations.Type(type="UserType_C_ZennouToukeiListKbn")
    public C_ZennouToukeiListKbn getZennoutoukeilistkbn() {
        return zennoutoukeilistkbn;
    }

    public void setZennoutoukeilistkbn(C_ZennouToukeiListKbn pZennoutoukeilistkbn) {
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
    }
    private BizDateYM zennoustartym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getZennoustartym() {
        return zennoustartym;
    }

    public void setZennoustartym(BizDateYM pZennoustartym) {
        zennoustartym = pZennoustartym;
    }

}