package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.mapping.GenIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.GenQIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 既払込Ｐ精算履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KihrkmpSeisanRireki}</td><td colspan="3">既払込Ｐ精算履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kihrkpssnaiyoukbn</td><td>既払込Ｐ精算内容区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KiharaiPseisanNaiyouKbn C_KiharaiPseisanNaiyouKbn}</td></tr>
 *  <tr><td>jyuutouym</td><td>充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>seijyutoukaisuum</td><td>精算充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>seijyutoukaisuuy</td><td>精算充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>misyuumikeikakbn</td><td>未収未経過区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MisyuumikeikaKbn C_MisyuumikeikaKbn}</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>seisanpgoukei</td><td>精算保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansansspgoukei</td><td>円換算精算保険料合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansantkykwsrateymd</td><td>円換算適用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yenkansantkykwsrate</td><td>円換算適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>henkank</td><td>返還金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansanhenkankin</td><td>円換算返還金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tuityouk</td><td>追徴金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansantuityoukin</td><td>円換算追徴金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zeimukwsratekjnymd</td><td>税務用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hituyoukeihiitijisytktysgk</td><td>必要経費一時所得調整額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_KihrkmpSeisanRireki
 * @see     GenIT_KihrkmpSeisanRireki
 * @see     QIT_KihrkmpSeisanRireki
 * @see     GenQIT_KihrkmpSeisanRireki
 */
public class PKIT_KihrkmpSeisanRireki extends AbstractExDBPrimaryKey<IT_KihrkmpSeisanRireki, PKIT_KihrkmpSeisanRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_KihrkmpSeisanRireki() {
    }

    public PKIT_KihrkmpSeisanRireki(
        String pKbnkey,
        String pSyono,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_KihrkmpSeisanRireki> getEntityClass() {
        return IT_KihrkmpSeisanRireki.class;
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
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}