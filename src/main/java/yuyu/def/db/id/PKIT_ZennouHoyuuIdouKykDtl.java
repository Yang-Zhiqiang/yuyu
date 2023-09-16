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
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.mapping.GenIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.GenQIT_ZennouHoyuuIdouKykDtl;
import yuyu.def.db.meta.QIT_ZennouHoyuuIdouKykDtl;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 前納保有異動契約明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ZennouHoyuuIdouKykDtl}</td><td colspan="3">前納保有異動契約明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKykmfksnctr kykmfksnctr}</td><td>契約ＭＦ更新ＣＴＲ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>henkousyoriymd</td><td>変更処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoukessanrecordkbn</td><td>前納決算レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keijyouym</td><td>計上年月</td><td>&nbsp;</td><td align="center">N</td><td>BizDateYM</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoucalckijyunymd</td><td>前納計算基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoubikinkbn</td><td>前納備金区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZennoubikinKbn C_ZennoubikinKbn}</td></tr>
 *  <tr><td>syukeiyakusyuruicd</td><td>主契約種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbnkeirisegcd</td><td>区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>zennoutoukeilistkbn</td><td>前納統計リスト区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZennouToukeiListKbn C_ZennouToukeiListKbn}</td></tr>
 *  <tr><td>keiyakuymd</td><td>契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennouwrbkrt</td><td>前納割引率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tndmatutkyrt</td><td>当年度末適用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tndzndkhikakukbn</td><td>当年度残高比較区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennoukaisiymd</td><td>前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoukbn</td><td>前納区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZennouKbn C_ZennouKbn}</td></tr>
 *  <tr><td>zennoukikan</td><td>前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennounyuukinymd</td><td>前納入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennounyuukinkgk</td><td>前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>toukimatuzennouzndk</td><td>当期末前納残高金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>toukijyuutoup</td><td>当期充当Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>toukizennouseisangk</td><td>当期前納精算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>toukizennounyuukinkgk</td><td>当期前納入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yokukinenbaraip</td><td>翌期年払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>wrbkrttkyrt</td><td>割引利率適用残高</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gkdtznnhyj</td><td>外貨建前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>znngaikakbn</td><td>前納外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yenkanyknhyj</td><td>円貨入金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>znnnyknjikawaserate</td><td>前納入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>znnnyknjikawaseratetkyuymd</td><td>前納入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ksnkisikawaserate</td><td>決算期始為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>znncalckjynymdkwsrate</td><td>前納計算基準日時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ksnkimatukawaserate</td><td>決算期末時点為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zennounyuukinkgktkmatu</td><td>前納入金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tkmatuznnzndktkmatu</td><td>当期末前納残高金額＿当期末</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ZennouHoyuuIdouKykDtl
 * @see     GenIT_ZennouHoyuuIdouKykDtl
 * @see     QIT_ZennouHoyuuIdouKykDtl
 * @see     GenQIT_ZennouHoyuuIdouKykDtl
 */
public class PKIT_ZennouHoyuuIdouKykDtl extends AbstractExDBPrimaryKey<IT_ZennouHoyuuIdouKykDtl, PKIT_ZennouHoyuuIdouKykDtl> {

    private static final long serialVersionUID = 1L;

    public PKIT_ZennouHoyuuIdouKykDtl() {
    }

    public PKIT_ZennouHoyuuIdouKykDtl(
        String pKbnkey,
        String pSyono,
        BizDate pSakuseiymd,
        String pSyoricd,
        Integer pKykmfksnctr
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        sakuseiymd = pSakuseiymd;
        syoricd = pSyoricd;
        kykmfksnctr = pKykmfksnctr;
    }

    @Transient
    @Override
    public Class<IT_ZennouHoyuuIdouKykDtl> getEntityClass() {
        return IT_ZennouHoyuuIdouKykDtl.class;
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
    private String syoricd;

    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }
    private Integer kykmfksnctr;

    public Integer getKykmfksnctr() {
        return kykmfksnctr;
    }

    public void setKykmfksnctr(Integer pKykmfksnctr) {
        kykmfksnctr = pKykmfksnctr;
    }

}