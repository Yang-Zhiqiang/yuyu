package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_BAK_KhHaitouKanri;
import yuyu.def.db.mapping.GenIT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.GenQIT_BAK_KhHaitouKanri;
import yuyu.def.db.meta.QIT_BAK_KhHaitouKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 配当管理バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHaitouKanri}</td><td colspan="3">配当管理バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">○</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitoukinskskbn haitoukinskskbn}</td><td>配当金作成区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HaitoukinsksKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitoumeisaikbn haitoumeisaikbn}</td><td>配当明細区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HaitoumeisaiKbn}</td></tr>
 *  <tr><td>fstkariwariatednendo</td><td>初回仮割当Ｄ年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>tounendod</td><td>当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>naiteikakuteikbn</td><td>内定確定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>kariwariatedshrymd</td><td>仮割当Ｄ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kariwariatedruigk</td><td>仮割当Ｄ累計額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedgngkkngk</td><td>仮割当Ｄ減額金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kariwariatedshrgk</td><td>仮割当Ｄ支払額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhHaitouKanri
 * @see     GenIT_BAK_KhHaitouKanri
 * @see     QIT_BAK_KhHaitouKanri
 * @see     GenQIT_BAK_KhHaitouKanri
 */
public class PKIT_BAK_KhHaitouKanri extends AbstractExDBPrimaryKey<IT_BAK_KhHaitouKanri, PKIT_BAK_KhHaitouKanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhHaitouKanri() {
    }

    public PKIT_BAK_KhHaitouKanri(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDateY pHaitounendo,
        Integer pRenno,
        C_HaitoukinsksKbn pHaitoukinskskbn,
        C_HaitoumeisaiKbn pHaitoumeisaikbn
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        haitounendo = pHaitounendo;
        renno = pRenno;
        haitoukinskskbn = pHaitoukinskskbn;
        haitoumeisaikbn = pHaitoumeisaikbn;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhHaitouKanri> getEntityClass() {
        return IT_BAK_KhHaitouKanri.class;
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
    private BizDateY haitounendo;

    @org.hibernate.annotations.Type(type="BizDateYType")
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
    private C_HaitoukinsksKbn haitoukinskskbn;

    @org.hibernate.annotations.Type(type="UserType_C_HaitoukinsksKbn")
    public C_HaitoukinsksKbn getHaitoukinskskbn() {
        return haitoukinskskbn;
    }

    public void setHaitoukinskskbn(C_HaitoukinsksKbn pHaitoukinskskbn) {
        haitoukinskskbn = pHaitoukinskskbn;
    }
    private C_HaitoumeisaiKbn haitoumeisaikbn;

    @org.hibernate.annotations.Type(type="UserType_C_HaitoumeisaiKbn")
    public C_HaitoumeisaiKbn getHaitoumeisaikbn() {
        return haitoumeisaikbn;
    }

    public void setHaitoumeisaikbn(C_HaitoumeisaiKbn pHaitoumeisaikbn) {
        haitoumeisaikbn = pHaitoumeisaikbn;
    }

}