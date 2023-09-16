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
import yuyu.def.db.entity.IT_YuukouseiNgTuuti;
import yuyu.def.db.mapping.GenIT_YuukouseiNgTuuti;
import yuyu.def.db.meta.GenQIT_YuukouseiNgTuuti;
import yuyu.def.db.meta.QIT_YuukouseiNgTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 有効性確認ＮＧ通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouseiNgTuuti}</td><td colspan="3">有効性確認ＮＧ通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shskyno</td><td>送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr1kj</td><td>送付先住所１（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr2kj</td><td>送付先住所２（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr3kj</td><td>送付先住所３（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsnmkj</td><td>送付先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj</td><td>問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseyno</td><td>問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr1kj</td><td>問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr2kj</td><td>問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr3kj</td><td>問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou1</td><td>問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou2</td><td>問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj2</td><td>第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno2</td><td>第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta1</td><td>お知らせ文言（４６桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta2</td><td>お知らせ文言（４６桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta3</td><td>お知らせ文言（４６桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta4</td><td>お知らせ文言（４６桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta5</td><td>お知らせ文言（４６桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta6</td><td>お知らせ文言（４６桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta7</td><td>お知らせ文言（４６桁）７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta8</td><td>お知らせ文言（４６桁）８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta9</td><td>お知らせ文言（４６桁）９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46keta10</td><td>お知らせ文言（４６桁）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokenryou</td><td>保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>creditcardinfo1</td><td>クレジットカード情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardinfo2</td><td>クレジットカード情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardinfo3</td><td>クレジットカード情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardmaskingmsg</td><td>クレジットカードマスキングＭＳＧ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>goiraijikoutoumongon1</td><td>ご依頼事項等文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>goiraijikoutoumongon2</td><td>ご依頼事項等文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>goiraijikoutoumongon3</td><td>ご依頼事項等文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon1</td><td>保険料のお払込み文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon2</td><td>保険料のお払込み文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon3</td><td>保険料のお払込み文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon4</td><td>保険料のお払込み文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon5</td><td>保険料のお払込み文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon6</td><td>保険料のお払込み文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon7</td><td>保険料のお払込み文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon8</td><td>保険料のお払込み文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>phrkmongon9</td><td>保険料のお払込み文言９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouseiNgTuuti
 * @see     GenIT_YuukouseiNgTuuti
 * @see     QIT_YuukouseiNgTuuti
 * @see     GenQIT_YuukouseiNgTuuti
 */
public class PKIT_YuukouseiNgTuuti extends AbstractExDBPrimaryKey<IT_YuukouseiNgTuuti, PKIT_YuukouseiNgTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_YuukouseiNgTuuti() {
    }

    public PKIT_YuukouseiNgTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_YuukouseiNgTuuti> getEntityClass() {
        return IT_YuukouseiNgTuuti.class;
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
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}