package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.IT_KessanZennou;
import yuyu.def.db.mapping.GenIT_KessanZennou;
import yuyu.def.db.meta.GenQIT_KessanZennou;
import yuyu.def.db.meta.QIT_KessanZennou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 決算用前納テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KessanZennou}</td><td colspan="3">決算用前納テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">○</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoukbn zennoukbn}</td><td>前納区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutoukeilistkbn zennoutoukeilistkbn}</td><td>前納統計リスト区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
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
 * </table>
 * @see     IT_KessanZennou
 * @see     GenIT_KessanZennou
 * @see     QIT_KessanZennou
 * @see     GenQIT_KessanZennou
 */
public class PKIT_KessanZennou extends AbstractExDBPrimaryKey<IT_KessanZennou, PKIT_KessanZennou> {

    private static final long serialVersionUID = 1L;

    public PKIT_KessanZennou() {
    }

    public PKIT_KessanZennou(
        String pKbnkey,
        String pSyono,
        C_Segcd pKbnkeirisegcd,
        String pZennoukbn,
        String pZennoutoukeilistkbn,
        BizDateYM pZennoustartym
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        kbnkeirisegcd = pKbnkeirisegcd;
        zennoukbn = pZennoukbn;
        zennoutoukeilistkbn = pZennoutoukeilistkbn;
        zennoustartym = pZennoustartym;
    }

    @Transient
    @Override
    public Class<IT_KessanZennou> getEntityClass() {
        return IT_KessanZennou.class;
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
    private C_Segcd kbnkeirisegcd;

    @org.hibernate.annotations.Type(type="UserType_C_Segcd")
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }
    private String zennoukbn;

    public String getZennoukbn() {
        return zennoukbn;
    }

    public void setZennoukbn(String pZennoukbn) {
        zennoukbn = pZennoukbn;
    }
    private String zennoutoukeilistkbn;

    public String getZennoutoukeilistkbn() {
        return zennoutoukeilistkbn;
    }

    public void setZennoutoukeilistkbn(String pZennoutoukeilistkbn) {
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