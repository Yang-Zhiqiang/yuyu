package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.id.PKBM_Dairiten;
import yuyu.def.db.meta.GenQBM_Dairiten;
import yuyu.def.db.meta.QBM_Dairiten;
import yuyu.def.db.type.UserType_C_DaisinHiDaisinKbn;
import yuyu.def.db.type.UserType_C_KydBosyuuDairitenHyouji;
import yuyu.def.db.type.UserType_C_KydsskKinyuuknHyouji;
import yuyu.def.db.type.UserType_C_MdhnSchemeDrtenHyouji;
import yuyu.def.db.type.UserType_C_TkrtkKinyuuknHyouji;
import yuyu.def.db.type.UserType_C_TykatukaiyouDrtenHyouji;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 代理店マスタ テーブルのマッピング情報クラスで、 {@link BM_Dairiten} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Dairiten}</td><td colspan="3">代理店マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBM_Dairiten ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennm drtennm}</td><td>代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjidairitennm kanjidairitennm}</td><td>漢字代理店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakukeiyakuymd itakukeiyakuymd}</td><td>委託契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItakukeiyakukaiyakuymd itakukeiyakukaiyakuymd}</td><td>委託契約解約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDairitentourokuymd dairitentourokuymd}</td><td>代理店登録年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDaisinhidaisinkbn daisinhidaisinkbn}</td><td>代申非代申区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DaisinHiDaisinKbn}</td></tr>
 *  <tr><td>{@link #getDrtkanrisosikicd1 drtkanrisosikicd1}</td><td>管理組織コード（１）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtkanrisosikicd2 drtkanrisosikicd2}</td><td>管理組織コード（２）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtkanrisosikicd3 drtkanrisosikicd3}</td><td>管理組織コード（３）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeisyousakidrtencd keisyousakidrtencd}</td><td>継承先代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKsymtdrtencd ksymtdrtencd}</td><td>継承元代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitentelno dairitentelno}</td><td>代理店電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenfaxno dairitenfaxno}</td><td>代理店ＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtentrkno drtentrkno}</td><td>代理店登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenkouryokukaisiymd dairitenkouryokukaisiymd}</td><td>代理店効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDairitenkouryokusyuuryouymd dairitenkouryokusyuuryouymd}</td><td>代理店効力終了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKinyuucd kinyuucd}</td><td>金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuusitencd kinyuusitencd}</td><td>金融機関支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenjimcd drtenjimcd}</td><td>代理店事務所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntndrtencd bntndrtencd}</td><td>分担相手代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari bunwari}</td><td>分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getMdhnschemedrtenhyouji mdhnschemedrtenhyouji}</td><td>窓販スキーム代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MdhnSchemeDrtenHyouji}</td></tr>
 *  <tr><td>{@link #getTykatukaiyoudrtenhyouji tykatukaiyoudrtenhyouji}</td><td>直扱用代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TykatukaiyouDrtenHyouji}</td></tr>
 *  <tr><td>{@link #getTkrtkkinyuuknhyouji tkrtkkinyuuknhyouji}</td><td>特例地域金融機関表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkrtkKinyuuknHyouji}</td></tr>
 *  <tr><td>{@link #getKydsskkinyuuknhyouji kydsskkinyuuknhyouji}</td><td>協同組織金融機関表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KydsskKinyuuknHyouji}</td></tr>
 *  <tr><td>{@link #getKydbosyuudairitenhyouji kydbosyuudairitenhyouji}</td><td>共同募集代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KydBosyuuDairitenHyouji}</td></tr>
 *  <tr><td>{@link #getYuuseijimusyocd yuuseijimusyocd}</td><td>郵政事務所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToukatudairitencd toukatudairitencd}</td><td>統括代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x1 drtensyouhncdkami3x1}</td><td>代理店商品コード上３桁＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux1 tsryshrkbntougetux1}</td><td>手数料支払区分（当月）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux1 tsryshrkbnyokugetux1}</td><td>手数料支払区分（翌月）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx1 bntnptnkbnx1}</td><td>分担パターン区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x2 drtensyouhncdkami3x2}</td><td>代理店商品コード上３桁＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux2 tsryshrkbntougetux2}</td><td>手数料支払区分（当月）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux2 tsryshrkbnyokugetux2}</td><td>手数料支払区分（翌月）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx2 bntnptnkbnx2}</td><td>分担パターン区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x3 drtensyouhncdkami3x3}</td><td>代理店商品コード上３桁＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux3 tsryshrkbntougetux3}</td><td>手数料支払区分（当月）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux3 tsryshrkbnyokugetux3}</td><td>手数料支払区分（翌月）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx3 bntnptnkbnx3}</td><td>分担パターン区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x4 drtensyouhncdkami3x4}</td><td>代理店商品コード上３桁＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux4 tsryshrkbntougetux4}</td><td>手数料支払区分（当月）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux4 tsryshrkbnyokugetux4}</td><td>手数料支払区分（翌月）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx4 bntnptnkbnx4}</td><td>分担パターン区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x5 drtensyouhncdkami3x5}</td><td>代理店商品コード上３桁＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux5 tsryshrkbntougetux5}</td><td>手数料支払区分（当月）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux5 tsryshrkbnyokugetux5}</td><td>手数料支払区分（翌月）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx5 bntnptnkbnx5}</td><td>分担パターン区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x6 drtensyouhncdkami3x6}</td><td>代理店商品コード上３桁＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux6 tsryshrkbntougetux6}</td><td>手数料支払区分（当月）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux6 tsryshrkbnyokugetux6}</td><td>手数料支払区分（翌月）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx6 bntnptnkbnx6}</td><td>分担パターン区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x7 drtensyouhncdkami3x7}</td><td>代理店商品コード上３桁＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux7 tsryshrkbntougetux7}</td><td>手数料支払区分（当月）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux7 tsryshrkbnyokugetux7}</td><td>手数料支払区分（翌月）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx7 bntnptnkbnx7}</td><td>分担パターン区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x8 drtensyouhncdkami3x8}</td><td>代理店商品コード上３桁＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux8 tsryshrkbntougetux8}</td><td>手数料支払区分（当月）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux8 tsryshrkbnyokugetux8}</td><td>手数料支払区分（翌月）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx8 bntnptnkbnx8}</td><td>分担パターン区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x9 drtensyouhncdkami3x9}</td><td>代理店商品コード上３桁＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux9 tsryshrkbntougetux9}</td><td>手数料支払区分（当月）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux9 tsryshrkbnyokugetux9}</td><td>手数料支払区分（翌月）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx9 bntnptnkbnx9}</td><td>分担パターン区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x10 drtensyouhncdkami3x10}</td><td>代理店商品コード上３桁＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux10 tsryshrkbntougetux10}</td><td>手数料支払区分（当月）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux10 tsryshrkbnyokugetux10}</td><td>手数料支払区分（翌月）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx10 bntnptnkbnx10}</td><td>分担パターン区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x11 drtensyouhncdkami3x11}</td><td>代理店商品コード上３桁＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux11 tsryshrkbntougetux11}</td><td>手数料支払区分（当月）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux11 tsryshrkbnyokugetux11}</td><td>手数料支払区分（翌月）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx11 bntnptnkbnx11}</td><td>分担パターン区分＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x12 drtensyouhncdkami3x12}</td><td>代理店商品コード上３桁＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux12 tsryshrkbntougetux12}</td><td>手数料支払区分（当月）＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux12 tsryshrkbnyokugetux12}</td><td>手数料支払区分（翌月）＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx12 bntnptnkbnx12}</td><td>分担パターン区分＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x13 drtensyouhncdkami3x13}</td><td>代理店商品コード上３桁＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux13 tsryshrkbntougetux13}</td><td>手数料支払区分（当月）＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux13 tsryshrkbnyokugetux13}</td><td>手数料支払区分（翌月）＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx13 bntnptnkbnx13}</td><td>分担パターン区分＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x14 drtensyouhncdkami3x14}</td><td>代理店商品コード上３桁＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux14 tsryshrkbntougetux14}</td><td>手数料支払区分（当月）＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux14 tsryshrkbnyokugetux14}</td><td>手数料支払区分（翌月）＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx14 bntnptnkbnx14}</td><td>分担パターン区分＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtensyouhncdkami3x15 drtensyouhncdkami3x15}</td><td>代理店商品コード上３桁＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbntougetux15 tsryshrkbntougetux15}</td><td>手数料支払区分（当月）＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryshrkbnyokugetux15 tsryshrkbnyokugetux15}</td><td>手数料支払区分（翌月）＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBntnptnkbnx15 bntnptnkbnx15}</td><td>分担パターン区分＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrybntnaitedrtencdx1 tsrybntnaitedrtencdx1}</td><td>手数料分担相手代理店コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrybntnwarix1 tsrybntnwarix1}</td><td>手数料分担割合＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTsrybntnaitedrtencdx2 tsrybntnaitedrtencdx2}</td><td>手数料分担相手代理店コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrybntnwarix2 tsrybntnwarix2}</td><td>手数料分担割合＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTsrybntnaitedrtencdx3 tsrybntnaitedrtencdx3}</td><td>手数料分担相手代理店コード＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrybntnwarix3 tsrybntnwarix3}</td><td>手数料分担割合＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTsrybntnaitedrtencdx4 tsrybntnaitedrtencdx4}</td><td>手数料分担相手代理店コード＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsrybntnwarix4 tsrybntnwarix4}</td><td>手数料分担割合＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHnsituhykranktougetu hnsituhykranktougetu}</td><td>品質評価ランク（当月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHnsituhykrankyokugetu hnsituhykrankyokugetu}</td><td>品質評価ランク（翌月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_Dairiten
 * @see     PKBM_Dairiten
 * @see     QBM_Dairiten
 * @see     GenQBM_Dairiten
 */
@MappedSuperclass
@Table(name=GenBM_Dairiten.TABLE_NAME)
@IdClass(value=PKBM_Dairiten.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DaisinHiDaisinKbn", typeClass=UserType_C_DaisinHiDaisinKbn.class),
    @TypeDef(name="UserType_C_KydBosyuuDairitenHyouji", typeClass=UserType_C_KydBosyuuDairitenHyouji.class),
    @TypeDef(name="UserType_C_KydsskKinyuuknHyouji", typeClass=UserType_C_KydsskKinyuuknHyouji.class),
    @TypeDef(name="UserType_C_MdhnSchemeDrtenHyouji", typeClass=UserType_C_MdhnSchemeDrtenHyouji.class),
    @TypeDef(name="UserType_C_TkrtkKinyuuknHyouji", typeClass=UserType_C_TkrtkKinyuuknHyouji.class),
    @TypeDef(name="UserType_C_TykatukaiyouDrtenHyouji", typeClass=UserType_C_TykatukaiyouDrtenHyouji.class)
})
public abstract class GenBM_Dairiten extends AbstractExDBEntity<BM_Dairiten, PKBM_Dairiten> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Dairiten";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENNM                  = "drtennm";
    public static final String KANJIDAIRITENNM          = "kanjidairitennm";
    public static final String ITAKUKEIYAKUYMD          = "itakukeiyakuymd";
    public static final String ITAKUKEIYAKUKAIYAKUYMD   = "itakukeiyakukaiyakuymd";
    public static final String DAIRITENTOUROKUYMD       = "dairitentourokuymd";
    public static final String DAISINHIDAISINKBN        = "daisinhidaisinkbn";
    public static final String DRTKANRISOSIKICD1        = "drtkanrisosikicd1";
    public static final String DRTKANRISOSIKICD2        = "drtkanrisosikicd2";
    public static final String DRTKANRISOSIKICD3        = "drtkanrisosikicd3";
    public static final String KEISYOUSAKIDRTENCD       = "keisyousakidrtencd";
    public static final String KSYMTDRTENCD             = "ksymtdrtencd";
    public static final String DAIRITENTELNO            = "dairitentelno";
    public static final String DAIRITENFAXNO            = "dairitenfaxno";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String DRTENTRKNO               = "drtentrkno";
    public static final String DAIRITENKOURYOKUKAISIYMD = "dairitenkouryokukaisiymd";
    public static final String DAIRITENKOURYOKUSYUURYOUYMD = "dairitenkouryokusyuuryouymd";
    public static final String KINYUUCD                 = "kinyuucd";
    public static final String KINYUUSITENCD            = "kinyuusitencd";
    public static final String DRTENJIMCD               = "drtenjimcd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String BNTNDRTENCD              = "bntndrtencd";
    public static final String BUNWARI                  = "bunwari";
    public static final String MDHNSCHEMEDRTENHYOUJI    = "mdhnschemedrtenhyouji";
    public static final String TYKATUKAIYOUDRTENHYOUJI  = "tykatukaiyoudrtenhyouji";
    public static final String TKRTKKINYUUKNHYOUJI      = "tkrtkkinyuuknhyouji";
    public static final String KYDSSKKINYUUKNHYOUJI     = "kydsskkinyuuknhyouji";
    public static final String KYDBOSYUUDAIRITENHYOUJI  = "kydbosyuudairitenhyouji";
    public static final String YUUSEIJIMUSYOCD          = "yuuseijimusyocd";
    public static final String TOUKATUDAIRITENCD        = "toukatudairitencd";
    public static final String DRTENSYOUHNCDKAMI3X1     = "drtensyouhncdkami3x1";
    public static final String TSRYSHRKBNTOUGETUX1      = "tsryshrkbntougetux1";
    public static final String TSRYSHRKBNYOKUGETUX1     = "tsryshrkbnyokugetux1";
    public static final String BNTNPTNKBNX1             = "bntnptnkbnx1";
    public static final String DRTENSYOUHNCDKAMI3X2     = "drtensyouhncdkami3x2";
    public static final String TSRYSHRKBNTOUGETUX2      = "tsryshrkbntougetux2";
    public static final String TSRYSHRKBNYOKUGETUX2     = "tsryshrkbnyokugetux2";
    public static final String BNTNPTNKBNX2             = "bntnptnkbnx2";
    public static final String DRTENSYOUHNCDKAMI3X3     = "drtensyouhncdkami3x3";
    public static final String TSRYSHRKBNTOUGETUX3      = "tsryshrkbntougetux3";
    public static final String TSRYSHRKBNYOKUGETUX3     = "tsryshrkbnyokugetux3";
    public static final String BNTNPTNKBNX3             = "bntnptnkbnx3";
    public static final String DRTENSYOUHNCDKAMI3X4     = "drtensyouhncdkami3x4";
    public static final String TSRYSHRKBNTOUGETUX4      = "tsryshrkbntougetux4";
    public static final String TSRYSHRKBNYOKUGETUX4     = "tsryshrkbnyokugetux4";
    public static final String BNTNPTNKBNX4             = "bntnptnkbnx4";
    public static final String DRTENSYOUHNCDKAMI3X5     = "drtensyouhncdkami3x5";
    public static final String TSRYSHRKBNTOUGETUX5      = "tsryshrkbntougetux5";
    public static final String TSRYSHRKBNYOKUGETUX5     = "tsryshrkbnyokugetux5";
    public static final String BNTNPTNKBNX5             = "bntnptnkbnx5";
    public static final String DRTENSYOUHNCDKAMI3X6     = "drtensyouhncdkami3x6";
    public static final String TSRYSHRKBNTOUGETUX6      = "tsryshrkbntougetux6";
    public static final String TSRYSHRKBNYOKUGETUX6     = "tsryshrkbnyokugetux6";
    public static final String BNTNPTNKBNX6             = "bntnptnkbnx6";
    public static final String DRTENSYOUHNCDKAMI3X7     = "drtensyouhncdkami3x7";
    public static final String TSRYSHRKBNTOUGETUX7      = "tsryshrkbntougetux7";
    public static final String TSRYSHRKBNYOKUGETUX7     = "tsryshrkbnyokugetux7";
    public static final String BNTNPTNKBNX7             = "bntnptnkbnx7";
    public static final String DRTENSYOUHNCDKAMI3X8     = "drtensyouhncdkami3x8";
    public static final String TSRYSHRKBNTOUGETUX8      = "tsryshrkbntougetux8";
    public static final String TSRYSHRKBNYOKUGETUX8     = "tsryshrkbnyokugetux8";
    public static final String BNTNPTNKBNX8             = "bntnptnkbnx8";
    public static final String DRTENSYOUHNCDKAMI3X9     = "drtensyouhncdkami3x9";
    public static final String TSRYSHRKBNTOUGETUX9      = "tsryshrkbntougetux9";
    public static final String TSRYSHRKBNYOKUGETUX9     = "tsryshrkbnyokugetux9";
    public static final String BNTNPTNKBNX9             = "bntnptnkbnx9";
    public static final String DRTENSYOUHNCDKAMI3X10    = "drtensyouhncdkami3x10";
    public static final String TSRYSHRKBNTOUGETUX10     = "tsryshrkbntougetux10";
    public static final String TSRYSHRKBNYOKUGETUX10    = "tsryshrkbnyokugetux10";
    public static final String BNTNPTNKBNX10            = "bntnptnkbnx10";
    public static final String DRTENSYOUHNCDKAMI3X11    = "drtensyouhncdkami3x11";
    public static final String TSRYSHRKBNTOUGETUX11     = "tsryshrkbntougetux11";
    public static final String TSRYSHRKBNYOKUGETUX11    = "tsryshrkbnyokugetux11";
    public static final String BNTNPTNKBNX11            = "bntnptnkbnx11";
    public static final String DRTENSYOUHNCDKAMI3X12    = "drtensyouhncdkami3x12";
    public static final String TSRYSHRKBNTOUGETUX12     = "tsryshrkbntougetux12";
    public static final String TSRYSHRKBNYOKUGETUX12    = "tsryshrkbnyokugetux12";
    public static final String BNTNPTNKBNX12            = "bntnptnkbnx12";
    public static final String DRTENSYOUHNCDKAMI3X13    = "drtensyouhncdkami3x13";
    public static final String TSRYSHRKBNTOUGETUX13     = "tsryshrkbntougetux13";
    public static final String TSRYSHRKBNYOKUGETUX13    = "tsryshrkbnyokugetux13";
    public static final String BNTNPTNKBNX13            = "bntnptnkbnx13";
    public static final String DRTENSYOUHNCDKAMI3X14    = "drtensyouhncdkami3x14";
    public static final String TSRYSHRKBNTOUGETUX14     = "tsryshrkbntougetux14";
    public static final String TSRYSHRKBNYOKUGETUX14    = "tsryshrkbnyokugetux14";
    public static final String BNTNPTNKBNX14            = "bntnptnkbnx14";
    public static final String DRTENSYOUHNCDKAMI3X15    = "drtensyouhncdkami3x15";
    public static final String TSRYSHRKBNTOUGETUX15     = "tsryshrkbntougetux15";
    public static final String TSRYSHRKBNYOKUGETUX15    = "tsryshrkbnyokugetux15";
    public static final String BNTNPTNKBNX15            = "bntnptnkbnx15";
    public static final String TSRYBNTNAITEDRTENCDX1    = "tsrybntnaitedrtencdx1";
    public static final String TSRYBNTNWARIX1           = "tsrybntnwarix1";
    public static final String TSRYBNTNAITEDRTENCDX2    = "tsrybntnaitedrtencdx2";
    public static final String TSRYBNTNWARIX2           = "tsrybntnwarix2";
    public static final String TSRYBNTNAITEDRTENCDX3    = "tsrybntnaitedrtencdx3";
    public static final String TSRYBNTNWARIX3           = "tsrybntnwarix3";
    public static final String TSRYBNTNAITEDRTENCDX4    = "tsrybntnaitedrtencdx4";
    public static final String TSRYBNTNWARIX4           = "tsrybntnwarix4";
    public static final String HNSITUHYKRANKTOUGETU     = "hnsituhykranktougetu";
    public static final String HNSITUHYKRANKYOKUGETU    = "hnsituhykrankyokugetu";

    private final PKBM_Dairiten primaryKey;

    public GenBM_Dairiten() {
        primaryKey = new PKBM_Dairiten();
    }

    public GenBM_Dairiten(String pDrtencd) {
        primaryKey = new PKBM_Dairiten(pDrtencd);
    }

    @Transient
    @Override
    public PKBM_Dairiten getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Dairiten> getMetaClass() {
        return QBM_Dairiten.class;
    }

    @Id
    @Column(name=GenBM_Dairiten.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    private String drtennm;

    @Column(name=GenBM_Dairiten.DRTENNM)
    public String getDrtennm() {
        return drtennm;
    }

    public void setDrtennm(String pDrtennm) {
        drtennm = pDrtennm;
    }

    private String kanjidairitennm;

    @Column(name=GenBM_Dairiten.KANJIDAIRITENNM)
    public String getKanjidairitennm() {
        return kanjidairitennm;
    }

    public void setKanjidairitennm(String pKanjidairitennm) {
        kanjidairitennm = pKanjidairitennm;
    }

    private BizDate itakukeiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Dairiten.ITAKUKEIYAKUYMD)
    public BizDate getItakukeiyakuymd() {
        return itakukeiyakuymd;
    }

    public void setItakukeiyakuymd(BizDate pItakukeiyakuymd) {
        itakukeiyakuymd = pItakukeiyakuymd;
    }

    private BizDate itakukeiyakukaiyakuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Dairiten.ITAKUKEIYAKUKAIYAKUYMD)
    public BizDate getItakukeiyakukaiyakuymd() {
        return itakukeiyakukaiyakuymd;
    }

    public void setItakukeiyakukaiyakuymd(BizDate pItakukeiyakukaiyakuymd) {
        itakukeiyakukaiyakuymd = pItakukeiyakukaiyakuymd;
    }

    private BizDate dairitentourokuymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Dairiten.DAIRITENTOUROKUYMD)
    public BizDate getDairitentourokuymd() {
        return dairitentourokuymd;
    }

    public void setDairitentourokuymd(BizDate pDairitentourokuymd) {
        dairitentourokuymd = pDairitentourokuymd;
    }

    private C_DaisinHiDaisinKbn daisinhidaisinkbn;

    @Type(type="UserType_C_DaisinHiDaisinKbn")
    @Column(name=GenBM_Dairiten.DAISINHIDAISINKBN)
    public C_DaisinHiDaisinKbn getDaisinhidaisinkbn() {
        return daisinhidaisinkbn;
    }

    public void setDaisinhidaisinkbn(C_DaisinHiDaisinKbn pDaisinhidaisinkbn) {
        daisinhidaisinkbn = pDaisinhidaisinkbn;
    }

    private String drtkanrisosikicd1;

    @Column(name=GenBM_Dairiten.DRTKANRISOSIKICD1)
    public String getDrtkanrisosikicd1() {
        return drtkanrisosikicd1;
    }

    public void setDrtkanrisosikicd1(String pDrtkanrisosikicd1) {
        drtkanrisosikicd1 = pDrtkanrisosikicd1;
    }

    private String drtkanrisosikicd2;

    @Column(name=GenBM_Dairiten.DRTKANRISOSIKICD2)
    public String getDrtkanrisosikicd2() {
        return drtkanrisosikicd2;
    }

    public void setDrtkanrisosikicd2(String pDrtkanrisosikicd2) {
        drtkanrisosikicd2 = pDrtkanrisosikicd2;
    }

    private String drtkanrisosikicd3;

    @Column(name=GenBM_Dairiten.DRTKANRISOSIKICD3)
    public String getDrtkanrisosikicd3() {
        return drtkanrisosikicd3;
    }

    public void setDrtkanrisosikicd3(String pDrtkanrisosikicd3) {
        drtkanrisosikicd3 = pDrtkanrisosikicd3;
    }

    private String keisyousakidrtencd;

    @Column(name=GenBM_Dairiten.KEISYOUSAKIDRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getKeisyousakidrtencd() {
        return keisyousakidrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeisyousakidrtencd(String pKeisyousakidrtencd) {
        keisyousakidrtencd = pKeisyousakidrtencd;
    }

    private String ksymtdrtencd;

    @Column(name=GenBM_Dairiten.KSYMTDRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getKsymtdrtencd() {
        return ksymtdrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKsymtdrtencd(String pKsymtdrtencd) {
        ksymtdrtencd = pKsymtdrtencd;
    }

    private String dairitentelno;

    @Column(name=GenBM_Dairiten.DAIRITENTELNO)
    public String getDairitentelno() {
        return dairitentelno;
    }

    public void setDairitentelno(String pDairitentelno) {
        dairitentelno = pDairitentelno;
    }

    private String dairitenfaxno;

    @Column(name=GenBM_Dairiten.DAIRITENFAXNO)
    public String getDairitenfaxno() {
        return dairitenfaxno;
    }

    public void setDairitenfaxno(String pDairitenfaxno) {
        dairitenfaxno = pDairitenfaxno;
    }

    private String oyadrtencd;

    @Column(name=GenBM_Dairiten.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String drtentrkno;

    @Column(name=GenBM_Dairiten.DRTENTRKNO)
    @Length(length=13)
    @SingleByteStrings
    @AlphaDigit
    public String getDrtentrkno() {
        return drtentrkno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtentrkno(String pDrtentrkno) {
        drtentrkno = pDrtentrkno;
    }

    private BizDate dairitenkouryokukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Dairiten.DAIRITENKOURYOKUKAISIYMD)
    public BizDate getDairitenkouryokukaisiymd() {
        return dairitenkouryokukaisiymd;
    }

    public void setDairitenkouryokukaisiymd(BizDate pDairitenkouryokukaisiymd) {
        dairitenkouryokukaisiymd = pDairitenkouryokukaisiymd;
    }

    private BizDate dairitenkouryokusyuuryouymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_Dairiten.DAIRITENKOURYOKUSYUURYOUYMD)
    public BizDate getDairitenkouryokusyuuryouymd() {
        return dairitenkouryokusyuuryouymd;
    }

    public void setDairitenkouryokusyuuryouymd(BizDate pDairitenkouryokusyuuryouymd) {
        dairitenkouryokusyuuryouymd = pDairitenkouryokusyuuryouymd;
    }

    private String kinyuucd;

    @Column(name=GenBM_Dairiten.KINYUUCD)
    public String getKinyuucd() {
        return kinyuucd;
    }

    public void setKinyuucd(String pKinyuucd) {
        kinyuucd = pKinyuucd;
    }

    private String kinyuusitencd;

    @Column(name=GenBM_Dairiten.KINYUUSITENCD)
    public String getKinyuusitencd() {
        return kinyuusitencd;
    }

    public void setKinyuusitencd(String pKinyuusitencd) {
        kinyuusitencd = pKinyuusitencd;
    }

    private String drtenjimcd;

    @Column(name=GenBM_Dairiten.DRTENJIMCD)
    @Length(length=4)
    @SingleByteStrings
    @AlphaDigit
    @HostInvalidCharacter
    public String getDrtenjimcd() {
        return drtenjimcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenjimcd(String pDrtenjimcd) {
        drtenjimcd = pDrtenjimcd;
    }

    private String daibosyuucd;

    @Column(name=GenBM_Dairiten.DAIBOSYUUCD)
    @HostInvalidCharacter
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String bntndrtencd;

    @Column(name=GenBM_Dairiten.BNTNDRTENCD)
    public String getBntndrtencd() {
        return bntndrtencd;
    }

    public void setBntndrtencd(String pBntndrtencd) {
        bntndrtencd = pBntndrtencd;
    }

    private BizNumber bunwari;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.BUNWARI)
    @RangeBizCalcable(min="0", max="100")
    public BizNumber getBunwari() {
        return bunwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBunwari(BizNumber pBunwari) {
        bunwari = pBunwari;
    }

    private C_MdhnSchemeDrtenHyouji mdhnschemedrtenhyouji;

    @Type(type="UserType_C_MdhnSchemeDrtenHyouji")
    @Column(name=GenBM_Dairiten.MDHNSCHEMEDRTENHYOUJI)
    public C_MdhnSchemeDrtenHyouji getMdhnschemedrtenhyouji() {
        return mdhnschemedrtenhyouji;
    }

    public void setMdhnschemedrtenhyouji(C_MdhnSchemeDrtenHyouji pMdhnschemedrtenhyouji) {
        mdhnschemedrtenhyouji = pMdhnschemedrtenhyouji;
    }

    private C_TykatukaiyouDrtenHyouji tykatukaiyoudrtenhyouji;

    @Type(type="UserType_C_TykatukaiyouDrtenHyouji")
    @Column(name=GenBM_Dairiten.TYKATUKAIYOUDRTENHYOUJI)
    public C_TykatukaiyouDrtenHyouji getTykatukaiyoudrtenhyouji() {
        return tykatukaiyoudrtenhyouji;
    }

    public void setTykatukaiyoudrtenhyouji(C_TykatukaiyouDrtenHyouji pTykatukaiyoudrtenhyouji) {
        tykatukaiyoudrtenhyouji = pTykatukaiyoudrtenhyouji;
    }

    private C_TkrtkKinyuuknHyouji tkrtkkinyuuknhyouji;

    @Type(type="UserType_C_TkrtkKinyuuknHyouji")
    @Column(name=GenBM_Dairiten.TKRTKKINYUUKNHYOUJI)
    public C_TkrtkKinyuuknHyouji getTkrtkkinyuuknhyouji() {
        return tkrtkkinyuuknhyouji;
    }

    public void setTkrtkkinyuuknhyouji(C_TkrtkKinyuuknHyouji pTkrtkkinyuuknhyouji) {
        tkrtkkinyuuknhyouji = pTkrtkkinyuuknhyouji;
    }

    private C_KydsskKinyuuknHyouji kydsskkinyuuknhyouji;

    @Type(type="UserType_C_KydsskKinyuuknHyouji")
    @Column(name=GenBM_Dairiten.KYDSSKKINYUUKNHYOUJI)
    public C_KydsskKinyuuknHyouji getKydsskkinyuuknhyouji() {
        return kydsskkinyuuknhyouji;
    }

    public void setKydsskkinyuuknhyouji(C_KydsskKinyuuknHyouji pKydsskkinyuuknhyouji) {
        kydsskkinyuuknhyouji = pKydsskkinyuuknhyouji;
    }

    private C_KydBosyuuDairitenHyouji kydbosyuudairitenhyouji;

    @Type(type="UserType_C_KydBosyuuDairitenHyouji")
    @Column(name=GenBM_Dairiten.KYDBOSYUUDAIRITENHYOUJI)
    public C_KydBosyuuDairitenHyouji getKydbosyuudairitenhyouji() {
        return kydbosyuudairitenhyouji;
    }

    public void setKydbosyuudairitenhyouji(C_KydBosyuuDairitenHyouji pKydbosyuudairitenhyouji) {
        kydbosyuudairitenhyouji = pKydbosyuudairitenhyouji;
    }

    private String yuuseijimusyocd;

    @Column(name=GenBM_Dairiten.YUUSEIJIMUSYOCD)
    public String getYuuseijimusyocd() {
        return yuuseijimusyocd;
    }

    public void setYuuseijimusyocd(String pYuuseijimusyocd) {
        yuuseijimusyocd = pYuuseijimusyocd;
    }

    private String toukatudairitencd;

    @Column(name=GenBM_Dairiten.TOUKATUDAIRITENCD)
    public String getToukatudairitencd() {
        return toukatudairitencd;
    }

    public void setToukatudairitencd(String pToukatudairitencd) {
        toukatudairitencd = pToukatudairitencd;
    }

    private String drtensyouhncdkami3x1;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X1)
    public String getDrtensyouhncdkami3x1() {
        return drtensyouhncdkami3x1;
    }

    public void setDrtensyouhncdkami3x1(String pDrtensyouhncdkami3x1) {
        drtensyouhncdkami3x1 = pDrtensyouhncdkami3x1;
    }

    private String tsryshrkbntougetux1;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX1)
    public String getTsryshrkbntougetux1() {
        return tsryshrkbntougetux1;
    }

    public void setTsryshrkbntougetux1(String pTsryshrkbntougetux1) {
        tsryshrkbntougetux1 = pTsryshrkbntougetux1;
    }

    private String tsryshrkbnyokugetux1;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX1)
    public String getTsryshrkbnyokugetux1() {
        return tsryshrkbnyokugetux1;
    }

    public void setTsryshrkbnyokugetux1(String pTsryshrkbnyokugetux1) {
        tsryshrkbnyokugetux1 = pTsryshrkbnyokugetux1;
    }

    private String bntnptnkbnx1;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX1)
    public String getBntnptnkbnx1() {
        return bntnptnkbnx1;
    }

    public void setBntnptnkbnx1(String pBntnptnkbnx1) {
        bntnptnkbnx1 = pBntnptnkbnx1;
    }

    private String drtensyouhncdkami3x2;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X2)
    public String getDrtensyouhncdkami3x2() {
        return drtensyouhncdkami3x2;
    }

    public void setDrtensyouhncdkami3x2(String pDrtensyouhncdkami3x2) {
        drtensyouhncdkami3x2 = pDrtensyouhncdkami3x2;
    }

    private String tsryshrkbntougetux2;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX2)
    public String getTsryshrkbntougetux2() {
        return tsryshrkbntougetux2;
    }

    public void setTsryshrkbntougetux2(String pTsryshrkbntougetux2) {
        tsryshrkbntougetux2 = pTsryshrkbntougetux2;
    }

    private String tsryshrkbnyokugetux2;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX2)
    public String getTsryshrkbnyokugetux2() {
        return tsryshrkbnyokugetux2;
    }

    public void setTsryshrkbnyokugetux2(String pTsryshrkbnyokugetux2) {
        tsryshrkbnyokugetux2 = pTsryshrkbnyokugetux2;
    }

    private String bntnptnkbnx2;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX2)
    public String getBntnptnkbnx2() {
        return bntnptnkbnx2;
    }

    public void setBntnptnkbnx2(String pBntnptnkbnx2) {
        bntnptnkbnx2 = pBntnptnkbnx2;
    }

    private String drtensyouhncdkami3x3;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X3)
    public String getDrtensyouhncdkami3x3() {
        return drtensyouhncdkami3x3;
    }

    public void setDrtensyouhncdkami3x3(String pDrtensyouhncdkami3x3) {
        drtensyouhncdkami3x3 = pDrtensyouhncdkami3x3;
    }

    private String tsryshrkbntougetux3;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX3)
    public String getTsryshrkbntougetux3() {
        return tsryshrkbntougetux3;
    }

    public void setTsryshrkbntougetux3(String pTsryshrkbntougetux3) {
        tsryshrkbntougetux3 = pTsryshrkbntougetux3;
    }

    private String tsryshrkbnyokugetux3;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX3)
    public String getTsryshrkbnyokugetux3() {
        return tsryshrkbnyokugetux3;
    }

    public void setTsryshrkbnyokugetux3(String pTsryshrkbnyokugetux3) {
        tsryshrkbnyokugetux3 = pTsryshrkbnyokugetux3;
    }

    private String bntnptnkbnx3;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX3)
    public String getBntnptnkbnx3() {
        return bntnptnkbnx3;
    }

    public void setBntnptnkbnx3(String pBntnptnkbnx3) {
        bntnptnkbnx3 = pBntnptnkbnx3;
    }

    private String drtensyouhncdkami3x4;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X4)
    public String getDrtensyouhncdkami3x4() {
        return drtensyouhncdkami3x4;
    }

    public void setDrtensyouhncdkami3x4(String pDrtensyouhncdkami3x4) {
        drtensyouhncdkami3x4 = pDrtensyouhncdkami3x4;
    }

    private String tsryshrkbntougetux4;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX4)
    public String getTsryshrkbntougetux4() {
        return tsryshrkbntougetux4;
    }

    public void setTsryshrkbntougetux4(String pTsryshrkbntougetux4) {
        tsryshrkbntougetux4 = pTsryshrkbntougetux4;
    }

    private String tsryshrkbnyokugetux4;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX4)
    public String getTsryshrkbnyokugetux4() {
        return tsryshrkbnyokugetux4;
    }

    public void setTsryshrkbnyokugetux4(String pTsryshrkbnyokugetux4) {
        tsryshrkbnyokugetux4 = pTsryshrkbnyokugetux4;
    }

    private String bntnptnkbnx4;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX4)
    public String getBntnptnkbnx4() {
        return bntnptnkbnx4;
    }

    public void setBntnptnkbnx4(String pBntnptnkbnx4) {
        bntnptnkbnx4 = pBntnptnkbnx4;
    }

    private String drtensyouhncdkami3x5;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X5)
    public String getDrtensyouhncdkami3x5() {
        return drtensyouhncdkami3x5;
    }

    public void setDrtensyouhncdkami3x5(String pDrtensyouhncdkami3x5) {
        drtensyouhncdkami3x5 = pDrtensyouhncdkami3x5;
    }

    private String tsryshrkbntougetux5;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX5)
    public String getTsryshrkbntougetux5() {
        return tsryshrkbntougetux5;
    }

    public void setTsryshrkbntougetux5(String pTsryshrkbntougetux5) {
        tsryshrkbntougetux5 = pTsryshrkbntougetux5;
    }

    private String tsryshrkbnyokugetux5;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX5)
    public String getTsryshrkbnyokugetux5() {
        return tsryshrkbnyokugetux5;
    }

    public void setTsryshrkbnyokugetux5(String pTsryshrkbnyokugetux5) {
        tsryshrkbnyokugetux5 = pTsryshrkbnyokugetux5;
    }

    private String bntnptnkbnx5;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX5)
    public String getBntnptnkbnx5() {
        return bntnptnkbnx5;
    }

    public void setBntnptnkbnx5(String pBntnptnkbnx5) {
        bntnptnkbnx5 = pBntnptnkbnx5;
    }

    private String drtensyouhncdkami3x6;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X6)
    public String getDrtensyouhncdkami3x6() {
        return drtensyouhncdkami3x6;
    }

    public void setDrtensyouhncdkami3x6(String pDrtensyouhncdkami3x6) {
        drtensyouhncdkami3x6 = pDrtensyouhncdkami3x6;
    }

    private String tsryshrkbntougetux6;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX6)
    public String getTsryshrkbntougetux6() {
        return tsryshrkbntougetux6;
    }

    public void setTsryshrkbntougetux6(String pTsryshrkbntougetux6) {
        tsryshrkbntougetux6 = pTsryshrkbntougetux6;
    }

    private String tsryshrkbnyokugetux6;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX6)
    public String getTsryshrkbnyokugetux6() {
        return tsryshrkbnyokugetux6;
    }

    public void setTsryshrkbnyokugetux6(String pTsryshrkbnyokugetux6) {
        tsryshrkbnyokugetux6 = pTsryshrkbnyokugetux6;
    }

    private String bntnptnkbnx6;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX6)
    public String getBntnptnkbnx6() {
        return bntnptnkbnx6;
    }

    public void setBntnptnkbnx6(String pBntnptnkbnx6) {
        bntnptnkbnx6 = pBntnptnkbnx6;
    }

    private String drtensyouhncdkami3x7;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X7)
    public String getDrtensyouhncdkami3x7() {
        return drtensyouhncdkami3x7;
    }

    public void setDrtensyouhncdkami3x7(String pDrtensyouhncdkami3x7) {
        drtensyouhncdkami3x7 = pDrtensyouhncdkami3x7;
    }

    private String tsryshrkbntougetux7;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX7)
    public String getTsryshrkbntougetux7() {
        return tsryshrkbntougetux7;
    }

    public void setTsryshrkbntougetux7(String pTsryshrkbntougetux7) {
        tsryshrkbntougetux7 = pTsryshrkbntougetux7;
    }

    private String tsryshrkbnyokugetux7;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX7)
    public String getTsryshrkbnyokugetux7() {
        return tsryshrkbnyokugetux7;
    }

    public void setTsryshrkbnyokugetux7(String pTsryshrkbnyokugetux7) {
        tsryshrkbnyokugetux7 = pTsryshrkbnyokugetux7;
    }

    private String bntnptnkbnx7;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX7)
    public String getBntnptnkbnx7() {
        return bntnptnkbnx7;
    }

    public void setBntnptnkbnx7(String pBntnptnkbnx7) {
        bntnptnkbnx7 = pBntnptnkbnx7;
    }

    private String drtensyouhncdkami3x8;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X8)
    public String getDrtensyouhncdkami3x8() {
        return drtensyouhncdkami3x8;
    }

    public void setDrtensyouhncdkami3x8(String pDrtensyouhncdkami3x8) {
        drtensyouhncdkami3x8 = pDrtensyouhncdkami3x8;
    }

    private String tsryshrkbntougetux8;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX8)
    public String getTsryshrkbntougetux8() {
        return tsryshrkbntougetux8;
    }

    public void setTsryshrkbntougetux8(String pTsryshrkbntougetux8) {
        tsryshrkbntougetux8 = pTsryshrkbntougetux8;
    }

    private String tsryshrkbnyokugetux8;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX8)
    public String getTsryshrkbnyokugetux8() {
        return tsryshrkbnyokugetux8;
    }

    public void setTsryshrkbnyokugetux8(String pTsryshrkbnyokugetux8) {
        tsryshrkbnyokugetux8 = pTsryshrkbnyokugetux8;
    }

    private String bntnptnkbnx8;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX8)
    public String getBntnptnkbnx8() {
        return bntnptnkbnx8;
    }

    public void setBntnptnkbnx8(String pBntnptnkbnx8) {
        bntnptnkbnx8 = pBntnptnkbnx8;
    }

    private String drtensyouhncdkami3x9;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X9)
    public String getDrtensyouhncdkami3x9() {
        return drtensyouhncdkami3x9;
    }

    public void setDrtensyouhncdkami3x9(String pDrtensyouhncdkami3x9) {
        drtensyouhncdkami3x9 = pDrtensyouhncdkami3x9;
    }

    private String tsryshrkbntougetux9;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX9)
    public String getTsryshrkbntougetux9() {
        return tsryshrkbntougetux9;
    }

    public void setTsryshrkbntougetux9(String pTsryshrkbntougetux9) {
        tsryshrkbntougetux9 = pTsryshrkbntougetux9;
    }

    private String tsryshrkbnyokugetux9;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX9)
    public String getTsryshrkbnyokugetux9() {
        return tsryshrkbnyokugetux9;
    }

    public void setTsryshrkbnyokugetux9(String pTsryshrkbnyokugetux9) {
        tsryshrkbnyokugetux9 = pTsryshrkbnyokugetux9;
    }

    private String bntnptnkbnx9;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX9)
    public String getBntnptnkbnx9() {
        return bntnptnkbnx9;
    }

    public void setBntnptnkbnx9(String pBntnptnkbnx9) {
        bntnptnkbnx9 = pBntnptnkbnx9;
    }

    private String drtensyouhncdkami3x10;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X10)
    public String getDrtensyouhncdkami3x10() {
        return drtensyouhncdkami3x10;
    }

    public void setDrtensyouhncdkami3x10(String pDrtensyouhncdkami3x10) {
        drtensyouhncdkami3x10 = pDrtensyouhncdkami3x10;
    }

    private String tsryshrkbntougetux10;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX10)
    public String getTsryshrkbntougetux10() {
        return tsryshrkbntougetux10;
    }

    public void setTsryshrkbntougetux10(String pTsryshrkbntougetux10) {
        tsryshrkbntougetux10 = pTsryshrkbntougetux10;
    }

    private String tsryshrkbnyokugetux10;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX10)
    public String getTsryshrkbnyokugetux10() {
        return tsryshrkbnyokugetux10;
    }

    public void setTsryshrkbnyokugetux10(String pTsryshrkbnyokugetux10) {
        tsryshrkbnyokugetux10 = pTsryshrkbnyokugetux10;
    }

    private String bntnptnkbnx10;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX10)
    public String getBntnptnkbnx10() {
        return bntnptnkbnx10;
    }

    public void setBntnptnkbnx10(String pBntnptnkbnx10) {
        bntnptnkbnx10 = pBntnptnkbnx10;
    }

    private String drtensyouhncdkami3x11;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X11)
    public String getDrtensyouhncdkami3x11() {
        return drtensyouhncdkami3x11;
    }

    public void setDrtensyouhncdkami3x11(String pDrtensyouhncdkami3x11) {
        drtensyouhncdkami3x11 = pDrtensyouhncdkami3x11;
    }

    private String tsryshrkbntougetux11;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX11)
    public String getTsryshrkbntougetux11() {
        return tsryshrkbntougetux11;
    }

    public void setTsryshrkbntougetux11(String pTsryshrkbntougetux11) {
        tsryshrkbntougetux11 = pTsryshrkbntougetux11;
    }

    private String tsryshrkbnyokugetux11;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX11)
    public String getTsryshrkbnyokugetux11() {
        return tsryshrkbnyokugetux11;
    }

    public void setTsryshrkbnyokugetux11(String pTsryshrkbnyokugetux11) {
        tsryshrkbnyokugetux11 = pTsryshrkbnyokugetux11;
    }

    private String bntnptnkbnx11;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX11)
    public String getBntnptnkbnx11() {
        return bntnptnkbnx11;
    }

    public void setBntnptnkbnx11(String pBntnptnkbnx11) {
        bntnptnkbnx11 = pBntnptnkbnx11;
    }

    private String drtensyouhncdkami3x12;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X12)
    public String getDrtensyouhncdkami3x12() {
        return drtensyouhncdkami3x12;
    }

    public void setDrtensyouhncdkami3x12(String pDrtensyouhncdkami3x12) {
        drtensyouhncdkami3x12 = pDrtensyouhncdkami3x12;
    }

    private String tsryshrkbntougetux12;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX12)
    public String getTsryshrkbntougetux12() {
        return tsryshrkbntougetux12;
    }

    public void setTsryshrkbntougetux12(String pTsryshrkbntougetux12) {
        tsryshrkbntougetux12 = pTsryshrkbntougetux12;
    }

    private String tsryshrkbnyokugetux12;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX12)
    public String getTsryshrkbnyokugetux12() {
        return tsryshrkbnyokugetux12;
    }

    public void setTsryshrkbnyokugetux12(String pTsryshrkbnyokugetux12) {
        tsryshrkbnyokugetux12 = pTsryshrkbnyokugetux12;
    }

    private String bntnptnkbnx12;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX12)
    public String getBntnptnkbnx12() {
        return bntnptnkbnx12;
    }

    public void setBntnptnkbnx12(String pBntnptnkbnx12) {
        bntnptnkbnx12 = pBntnptnkbnx12;
    }

    private String drtensyouhncdkami3x13;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X13)
    public String getDrtensyouhncdkami3x13() {
        return drtensyouhncdkami3x13;
    }

    public void setDrtensyouhncdkami3x13(String pDrtensyouhncdkami3x13) {
        drtensyouhncdkami3x13 = pDrtensyouhncdkami3x13;
    }

    private String tsryshrkbntougetux13;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX13)
    public String getTsryshrkbntougetux13() {
        return tsryshrkbntougetux13;
    }

    public void setTsryshrkbntougetux13(String pTsryshrkbntougetux13) {
        tsryshrkbntougetux13 = pTsryshrkbntougetux13;
    }

    private String tsryshrkbnyokugetux13;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX13)
    public String getTsryshrkbnyokugetux13() {
        return tsryshrkbnyokugetux13;
    }

    public void setTsryshrkbnyokugetux13(String pTsryshrkbnyokugetux13) {
        tsryshrkbnyokugetux13 = pTsryshrkbnyokugetux13;
    }

    private String bntnptnkbnx13;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX13)
    public String getBntnptnkbnx13() {
        return bntnptnkbnx13;
    }

    public void setBntnptnkbnx13(String pBntnptnkbnx13) {
        bntnptnkbnx13 = pBntnptnkbnx13;
    }

    private String drtensyouhncdkami3x14;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X14)
    public String getDrtensyouhncdkami3x14() {
        return drtensyouhncdkami3x14;
    }

    public void setDrtensyouhncdkami3x14(String pDrtensyouhncdkami3x14) {
        drtensyouhncdkami3x14 = pDrtensyouhncdkami3x14;
    }

    private String tsryshrkbntougetux14;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX14)
    public String getTsryshrkbntougetux14() {
        return tsryshrkbntougetux14;
    }

    public void setTsryshrkbntougetux14(String pTsryshrkbntougetux14) {
        tsryshrkbntougetux14 = pTsryshrkbntougetux14;
    }

    private String tsryshrkbnyokugetux14;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX14)
    public String getTsryshrkbnyokugetux14() {
        return tsryshrkbnyokugetux14;
    }

    public void setTsryshrkbnyokugetux14(String pTsryshrkbnyokugetux14) {
        tsryshrkbnyokugetux14 = pTsryshrkbnyokugetux14;
    }

    private String bntnptnkbnx14;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX14)
    public String getBntnptnkbnx14() {
        return bntnptnkbnx14;
    }

    public void setBntnptnkbnx14(String pBntnptnkbnx14) {
        bntnptnkbnx14 = pBntnptnkbnx14;
    }

    private String drtensyouhncdkami3x15;

    @Column(name=GenBM_Dairiten.DRTENSYOUHNCDKAMI3X15)
    public String getDrtensyouhncdkami3x15() {
        return drtensyouhncdkami3x15;
    }

    public void setDrtensyouhncdkami3x15(String pDrtensyouhncdkami3x15) {
        drtensyouhncdkami3x15 = pDrtensyouhncdkami3x15;
    }

    private String tsryshrkbntougetux15;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNTOUGETUX15)
    public String getTsryshrkbntougetux15() {
        return tsryshrkbntougetux15;
    }

    public void setTsryshrkbntougetux15(String pTsryshrkbntougetux15) {
        tsryshrkbntougetux15 = pTsryshrkbntougetux15;
    }

    private String tsryshrkbnyokugetux15;

    @Column(name=GenBM_Dairiten.TSRYSHRKBNYOKUGETUX15)
    public String getTsryshrkbnyokugetux15() {
        return tsryshrkbnyokugetux15;
    }

    public void setTsryshrkbnyokugetux15(String pTsryshrkbnyokugetux15) {
        tsryshrkbnyokugetux15 = pTsryshrkbnyokugetux15;
    }

    private String bntnptnkbnx15;

    @Column(name=GenBM_Dairiten.BNTNPTNKBNX15)
    public String getBntnptnkbnx15() {
        return bntnptnkbnx15;
    }

    public void setBntnptnkbnx15(String pBntnptnkbnx15) {
        bntnptnkbnx15 = pBntnptnkbnx15;
    }

    private String tsrybntnaitedrtencdx1;

    @Column(name=GenBM_Dairiten.TSRYBNTNAITEDRTENCDX1)
    public String getTsrybntnaitedrtencdx1() {
        return tsrybntnaitedrtencdx1;
    }

    public void setTsrybntnaitedrtencdx1(String pTsrybntnaitedrtencdx1) {
        tsrybntnaitedrtencdx1 = pTsrybntnaitedrtencdx1;
    }

    private BizNumber tsrybntnwarix1;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.TSRYBNTNWARIX1)
    public BizNumber getTsrybntnwarix1() {
        return tsrybntnwarix1;
    }

    public void setTsrybntnwarix1(BizNumber pTsrybntnwarix1) {
        tsrybntnwarix1 = pTsrybntnwarix1;
    }

    private String tsrybntnaitedrtencdx2;

    @Column(name=GenBM_Dairiten.TSRYBNTNAITEDRTENCDX2)
    public String getTsrybntnaitedrtencdx2() {
        return tsrybntnaitedrtencdx2;
    }

    public void setTsrybntnaitedrtencdx2(String pTsrybntnaitedrtencdx2) {
        tsrybntnaitedrtencdx2 = pTsrybntnaitedrtencdx2;
    }

    private BizNumber tsrybntnwarix2;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.TSRYBNTNWARIX2)
    public BizNumber getTsrybntnwarix2() {
        return tsrybntnwarix2;
    }

    public void setTsrybntnwarix2(BizNumber pTsrybntnwarix2) {
        tsrybntnwarix2 = pTsrybntnwarix2;
    }

    private String tsrybntnaitedrtencdx3;

    @Column(name=GenBM_Dairiten.TSRYBNTNAITEDRTENCDX3)
    public String getTsrybntnaitedrtencdx3() {
        return tsrybntnaitedrtencdx3;
    }

    public void setTsrybntnaitedrtencdx3(String pTsrybntnaitedrtencdx3) {
        tsrybntnaitedrtencdx3 = pTsrybntnaitedrtencdx3;
    }

    private BizNumber tsrybntnwarix3;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.TSRYBNTNWARIX3)
    public BizNumber getTsrybntnwarix3() {
        return tsrybntnwarix3;
    }

    public void setTsrybntnwarix3(BizNumber pTsrybntnwarix3) {
        tsrybntnwarix3 = pTsrybntnwarix3;
    }

    private String tsrybntnaitedrtencdx4;

    @Column(name=GenBM_Dairiten.TSRYBNTNAITEDRTENCDX4)
    public String getTsrybntnaitedrtencdx4() {
        return tsrybntnaitedrtencdx4;
    }

    public void setTsrybntnaitedrtencdx4(String pTsrybntnaitedrtencdx4) {
        tsrybntnaitedrtencdx4 = pTsrybntnaitedrtencdx4;
    }

    private BizNumber tsrybntnwarix4;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.TSRYBNTNWARIX4)
    public BizNumber getTsrybntnwarix4() {
        return tsrybntnwarix4;
    }

    public void setTsrybntnwarix4(BizNumber pTsrybntnwarix4) {
        tsrybntnwarix4 = pTsrybntnwarix4;
    }

    private BizNumber hnsituhykranktougetu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.HNSITUHYKRANKTOUGETU)
    public BizNumber getHnsituhykranktougetu() {
        return hnsituhykranktougetu;
    }

    public void setHnsituhykranktougetu(BizNumber pHnsituhykranktougetu) {
        hnsituhykranktougetu = pHnsituhykranktougetu;
    }

    private BizNumber hnsituhykrankyokugetu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_Dairiten.HNSITUHYKRANKYOKUGETU)
    public BizNumber getHnsituhykrankyokugetu() {
        return hnsituhykrankyokugetu;
    }

    public void setHnsituhykrankyokugetu(BizNumber pHnsituhykrankyokugetu) {
        hnsituhykrankyokugetu = pHnsituhykrankyokugetu;
    }
}