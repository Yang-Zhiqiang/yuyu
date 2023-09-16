package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.mapping.GenIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.meta.GenQIT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.meta.QIT_KhGinkouMdhnMisyuuInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 銀行窓販未収情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhGinkouMdhnMisyuuInfo}</td><td colspan="3">銀行窓販未収情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenymd datarenymd}</td><td>データ連動日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwbsydrtencd</td><td>ＧＷ＿募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwdatakbn</td><td>ＧＷ＿データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwdatasakuseiymd</td><td>ＧＷ＿データ作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwhknkaisyacd</td><td>ＧＷ＿保険会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwhknsyuruicd</td><td>ＧＷ＿保険種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwsyonosyuban</td><td>ＧＷ＿証券番号主番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwmisyuutatekaekbn</td><td>ＧＷ＿未収・立替区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwmisyuutatekaeym</td><td>ＧＷ＿未収・立替発生年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwmisyuukg</td><td>ＧＷ＿未収金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwbnkaisuu</td><td>ＧＷ＿分割回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwmisyuujiyuu</td><td>ＧＷ＿未収事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwjikaidatakousinymd</td><td>ＧＷ＿次回データ更新日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ikkatubaraikbn</td><td>一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKbn C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>ikkatubaraikaisuu</td><td>一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKaisuuKbn C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhGinkouMdhnMisyuuInfo
 * @see     GenIT_KhGinkouMdhnMisyuuInfo
 * @see     QIT_KhGinkouMdhnMisyuuInfo
 * @see     GenQIT_KhGinkouMdhnMisyuuInfo
 */
public class PKIT_KhGinkouMdhnMisyuuInfo extends AbstractExDBPrimaryKey<IT_KhGinkouMdhnMisyuuInfo, PKIT_KhGinkouMdhnMisyuuInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhGinkouMdhnMisyuuInfo() {
    }

    public PKIT_KhGinkouMdhnMisyuuInfo(
        String pKbnkey,
        BizDate pDatarenymd,
        String pSyono,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        datarenymd = pDatarenymd;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_KhGinkouMdhnMisyuuInfo> getEntityClass() {
        return IT_KhGinkouMdhnMisyuuInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private BizDate datarenymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDatarenymd() {
        return datarenymd;
    }

    public void setDatarenymd(BizDate pDatarenymd) {
        datarenymd = pDatarenymd;
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

}