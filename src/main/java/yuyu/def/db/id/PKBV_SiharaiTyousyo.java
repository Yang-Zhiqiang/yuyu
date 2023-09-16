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
import yuyu.def.db.entity.BV_SiharaiTyousyo;
import yuyu.def.db.mapping.GenBV_SiharaiTyousyo;
import yuyu.def.db.meta.GenQBV_SiharaiTyousyo;
import yuyu.def.db.meta.QBV_SiharaiTyousyo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払調書ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BV_SiharaiTyousyo}</td><td colspan="3">支払調書ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getShrtysyrenno shrtysyrenno}</td><td>支払調書連番</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>kacd</td><td>課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>hknsyukigou</td><td>保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn</td><td>払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyknen</td><td>契約者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>annaihuyouriyuukbn</td><td>案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mfadrsiyouhyouji</td><td>ＭＦ住所使用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kihrpdmiseibidisp</td><td>既払ＰＤ未整備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kihrpseibiyoudisp</td><td>既払込Ｐ整備要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrgk</td><td>支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>warimsishrgk</td><td>割増支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>znnphr</td><td>前納Ｐ等返戻金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ttkekstkganri</td><td>立替貸付元利金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sshkd</td><td>差引Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sshkshrgk</td><td>差引支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mihrkmp</td><td>未払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>shrymd</td><td>支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoritaisyoukbn</td><td>処理対象区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysytsinyno</td><td>支払調書郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysyadr1kj</td><td>支払調書住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysyadr2kj</td><td>支払調書住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysyadr3kj</td><td>支払調書住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjdaihyouuktnm</td><td>漢字代表受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtienrsk</td><td>支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons</td><td>基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtysysyuruicd</td><td>支払調書種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teknjikihrpseibidisp</td><td>転換時既払込Ｐ未整備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kihrkmp</td><td>既払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>onlinecentercutkbn</td><td>オンラインセンターカット区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>htykeihihnsyukbn</td><td>必要経費編集区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syuseijtshrd</td><td>修正後実支払Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>touduketorihouhoukbn</td><td>当Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkkn</td><td>年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>banknmkn</td><td>銀行名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitennmkn</td><td>支店名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>yokinknmkn</td><td>預金口座種目名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakuseiymd</td><td>作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykmnmeigibangou</td><td>契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktmnmeigibangou</td><td>受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jigyoukykmndantaicd</td><td>事業契約用ＭＮ団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mnsaiannaihnskakbn</td><td>ＭＮ再案内本社回送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huho2kykdisp</td><td>普保Ⅱ契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysyhknsyukbn</td><td>支払調書保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrtysyhknsyuKbn C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>shrtysykurikosidisp</td><td>支払調書繰越表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>synyhsjykykndisp</td><td>収入保障年金受給権表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tblsakuseihunodisp</td><td>テープ作成不能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daihyouktkbn</td><td>代表受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinyno</td><td>（旧）通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr1kj</td><td>（旧）通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr2kj</td><td>（旧）通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldtsinadr3kj</td><td>（旧）通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oldkyknmkj</td><td>（旧）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrkykhtykeihiyouhyj</td><td>支払時契約者必要経費要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrkykhtykeihi</td><td>支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     BV_SiharaiTyousyo
 * @see     GenBV_SiharaiTyousyo
 * @see     QBV_SiharaiTyousyo
 * @see     GenQBV_SiharaiTyousyo
 */
public class PKBV_SiharaiTyousyo extends AbstractExDBPrimaryKey<BV_SiharaiTyousyo, PKBV_SiharaiTyousyo> {

    private static final long serialVersionUID = 1L;

    public PKBV_SiharaiTyousyo() {
    }

    public PKBV_SiharaiTyousyo(
        String pSubSystemId,
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        subSystemId = pSubSystemId;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
        shrtysyrenno = pShrtysyrenno;
    }

    @Transient
    @Override
    public Class<BV_SiharaiTyousyo> getEntityClass() {
        return BV_SiharaiTyousyo.class;
    }

    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }
    private Long shrtysyrenno;

    public Long getShrtysyrenno() {
        return shrtysyrenno;
    }

    public void setShrtysyrenno(Long pShrtysyrenno) {
        shrtysyrenno = pShrtysyrenno;
    }

}