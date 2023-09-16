package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.mapping.GenIT_KhHenkouRireki;
import yuyu.def.db.meta.GenQIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouRireki}</td><td colspan="3">契約保全変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tablenm</td><td>テーブル名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tableid</td><td>テーブルＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hnksyuruikbn</td><td>変更種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HnkSyuruiKbn C_HnkSyuruiKbn}</td></tr>
 *  <tr><td>hanbetukoumokunm</td><td>判別項目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkoukoumokuid</td><td>変更項目ID</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>henkoukoumokunm</td><td>変更項目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bfrnaiyouoriginal</td><td>変更前内容原本</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bfrnaiyou</td><td>変更前内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newnaiyouoriginal</td><td>変更後内容原本</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newnaiyou</td><td>変更後内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHenkouRireki
 * @see     GenIT_KhHenkouRireki
 * @see     QIT_KhHenkouRireki
 * @see     GenQIT_KhHenkouRireki
 */
public class PKIT_KhHenkouRireki extends AbstractExDBPrimaryKey<IT_KhHenkouRireki, PKIT_KhHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhHenkouRireki() {
    }

    public PKIT_KhHenkouRireki(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        Integer pRenno3keta
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<IT_KhHenkouRireki> getEntityClass() {
        return IT_KhHenkouRireki.class;
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
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}