package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkYendtHnk;
import yuyu.def.db.mapping.GenIT_BAK_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.GenQIT_BAK_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_BAK_KhHenkouUktkYendtHnk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更受付内容（円建変更）バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHenkouUktkYendtHnk}</td><td colspan="3">契約保全変更受付内容（円建変更）バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHozenhenkouuktkrenno hozenhenkouuktkrenno}</td><td>保全変更受付連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yendthnkymd</td><td>円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mkhgktttymd</td><td>目標額到達日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mkhgktttkaiyakuhr</td><td>目標額到達時解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newkaiyakuhr</td><td>変更後解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkhr</td><td>円建変更時返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nyuuryokuhassoukbn</td><td>入力発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>hnskariyuu1</td><td>本社回送理由１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnskariyuuKbn C_HnskariyuuKbn}</td></tr>
 *  <tr><td>hnskariyuu2</td><td>本社回送理由２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnskariyuuKbn C_HnskariyuuKbn}</td></tr>
 *  <tr><td>yendthnkkaiyakuhrgaika</td><td>円建変更時解約返戻金（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkkaiyakuhryen</td><td>円建変更時解約返戻金（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkjikwsrate</td><td>円建変更時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>newsyouhncd</td><td>変更後商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newsyouhnsdno</td><td>変更後商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yendthnkkihons</td><td>円建変更後基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newhokenryou</td><td>変更後保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>newkyktuukasyu</td><td>変更後契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>newryouritusdno</td><td>変更後料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>newtumitateriritu</td><td>変更後積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>newyoteiriritu</td><td>変更後予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>mkhgk</td><td>目標額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkkjnkg</td><td>円建変更基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>targettkmokuhyouti</td><td>ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yendthnkbfrsibousyen</td><td>円建変更前死亡Ｓ（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkjiptumitatekin</td><td>円建変更時保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkjisjkkktyouseiritu</td><td>円建変更時市場価格調整率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>yendthnkjikaiyakukjgk</td><td>円建変更時解約控除額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yendthnkjikaiyakukoujyoritu</td><td>円建変更時解約控除率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaiyakukoujyoritutekiumu</td><td>解約控除率適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     IT_BAK_KhHenkouUktkYendtHnk
 * @see     GenIT_BAK_KhHenkouUktkYendtHnk
 * @see     QIT_BAK_KhHenkouUktkYendtHnk
 * @see     GenQIT_BAK_KhHenkouUktkYendtHnk
 */
public class PKIT_BAK_KhHenkouUktkYendtHnk extends AbstractExDBPrimaryKey<IT_BAK_KhHenkouUktkYendtHnk, PKIT_BAK_KhHenkouUktkYendtHnk> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhHenkouUktkYendtHnk() {
    }

    public PKIT_BAK_KhHenkouUktkYendtHnk(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pHozenhenkouuktkrenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhHenkouUktkYendtHnk> getEntityClass() {
        return IT_BAK_KhHenkouUktkYendtHnk.class;
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
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private Integer hozenhenkouuktkrenno;

    public Integer getHozenhenkouuktkrenno() {
        return hozenhenkouuktkrenno;
    }

    public void setHozenhenkouuktkrenno(Integer pHozenhenkouuktkrenno) {
        hozenhenkouuktkrenno = pHozenhenkouuktkrenno;
    }

}