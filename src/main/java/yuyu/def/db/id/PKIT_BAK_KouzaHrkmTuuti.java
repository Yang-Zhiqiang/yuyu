package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.def.db.entity.IT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.mapping.GenIT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.meta.GenQIT_BAK_KouzaHrkmTuuti;
import yuyu.def.db.meta.QIT_BAK_KouzaHrkmTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振込通知バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KouzaHrkmTuuti}</td><td colspan="3">口座振込通知バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKrkno krkno}</td><td>仮受番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyouymd</td><td>帳票作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>hurikomiymd</td><td>振込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrgk</td><td>支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shririyuu1</td><td>支払理由１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shririyuu2</td><td>支払理由２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shririyuu3</td><td>支払理由３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteikouza1</td><td>指定口座１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteikouza2</td><td>指定口座２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteikouza3</td><td>指定口座３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteikouza4</td><td>指定口座４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteikouza5</td><td>指定口座５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KouzaHrkmTuuti
 * @see     GenIT_BAK_KouzaHrkmTuuti
 * @see     QIT_BAK_KouzaHrkmTuuti
 * @see     GenQIT_BAK_KouzaHrkmTuuti
 */
public class PKIT_BAK_KouzaHrkmTuuti extends AbstractExDBPrimaryKey<IT_BAK_KouzaHrkmTuuti, PKIT_BAK_KouzaHrkmTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KouzaHrkmTuuti() {
    }

    public PKIT_BAK_KouzaHrkmTuuti(
        String pKbnkey,
        String pSyono,
        Integer pKrkno,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        krkno = pKrkno;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KouzaHrkmTuuti> getEntityClass() {
        return IT_BAK_KouzaHrkmTuuti.class;
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
    private Integer krkno;

    public Integer getKrkno() {
        return krkno;
    }

    public void setKrkno(Integer pKrkno) {
        krkno = pKrkno;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}