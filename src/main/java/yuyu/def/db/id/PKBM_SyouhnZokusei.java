package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.mapping.GenBM_SyouhnZokusei;
import yuyu.def.db.meta.GenQBM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SyouhnZokusei;

/**
 * 商品属性マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnZokusei}</td><td colspan="3">商品属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syohnsortno</td><td>商品ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mossyohnsortno</td><td>申込書商品ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmryaku</td><td>商品名（略称）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmryaku5</td><td>商品名（略称）_5</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmsyouken</td><td>商品名（証券用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnmworklist</td><td>商品名（ワークリスト用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykfromymd</td><td>契約日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktoymd</td><td>契約日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujifromymd</td><td>表示日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujitoymd</td><td>表示日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>hknsyuruino</td><td>保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknsyuruiNo C_HknsyuruiNo}</td></tr>
 *  <tr><td>toukeiyouhokensyuruikbn</td><td>統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ijitoukeihokensyuruikbn</td><td>医事統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IjitoukeiHokensyuruiKbn C_IjitoukeiHokensyuruiKbn}</td></tr>
 *  <tr><td>isatoukeihokensyuruicd</td><td>医査統計用保険種類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IsatoukeiHokensyuruicd C_IsatoukeiHokensyuruicd}</td></tr>
 *  <tr><td>yoteirirituhendoukbn</td><td>予定利率変動区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YoteirirituhendouKbn C_YoteirirituhendouKbn}</td></tr>
 *  <tr><td>yoteirirituhosyoukkn</td><td>予定利率保証期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yoteirirituminhosyouritu</td><td>予定利率最低保証率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>nkgnshosyouritu</td><td>年金原資最低保証率</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dai1hknkkn</td><td>第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>drtsyouhinsikibetukbn</td><td>代理店商品識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DrtSyouhinSikibetuKbn C_DrtSyouhinSikibetuKbn}</td></tr>
 *  <tr><td>drthrkhouhoukbn</td><td>代理店払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtplannmkbn</td><td>代理店プラン名区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>ptratkituukasiteikbn</td><td>保険料取扱通貨指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PtratkituukasiteiKbn C_PtratkituukasiteiKbn}</td></tr>
 *  <tr><td>jikounensuu</td><td>時効年数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ntgksbairitu</td><td>日額Ｓ倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sbhkuktumu</td><td>死亡保険金受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sbkyuuhukinuktumu</td><td>死亡給付金受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sbhnknuktumu</td><td>死亡返還金受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sbuktumu</td><td>死亡受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mnkuktumu</td><td>満期受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>siteidairiumu</td><td>指定代理人有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktumu</td><td>告知有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hjyumu</td><td>報状有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>musenumu</td><td>無選択有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syokugyoukktumu</td><td>職業告知有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kokutikbn</td><td>告知区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KokutiKbn C_KokutiKbn}</td></tr>
 *  <tr><td>sdumu</td><td>Ｓ建有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pdumu</td><td>Ｐ建有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gijipdumu</td><td>擬似Ｐ建有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hokenkngkyakujyouumu</td><td>保険金額約定有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>teikisiharaikinumu</td><td>定期支払金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyhkataumu</td><td>給付型有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syukyhkinkataumu</td><td>手術給付金型有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>rokudaildumu</td><td>６大生活習慣病追加給付型有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>khnkyhkgbairituumu</td><td>基本給付金額倍率有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>itijibrumu</td><td>一時払有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>heijyunbaraiumu</td><td>平準払有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zennouumu</td><td>前納有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>itibuzennoutekiumu</td><td>一部前納適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zenkizennoutekiumu</td><td>全期前納適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ikkatubaraiumu</td><td>一括払有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>teikiikkatubaraiumu</td><td>定期一括払有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pwaribikikbn</td><td>保険料割引区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PWaribikiKbn C_PWaribikiKbn}</td></tr>
 *  <tr><td>tkjyrmtekiumu</td><td>特条料増適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tkjyskgntekiumu</td><td>特条削減適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>htnpbuitekiumu</td><td>不担保部位適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tokkoudosghtnptekiumu</td><td>特定高度障害不担保適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jkntekiumu</td><td>条件付適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>livtkumu</td><td>リビングニーズ特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kzktourokuserviceumu</td><td>家族登録サービス有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktkumu</td><td>被保険者代理特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdrtkykumu</td><td>契約者代理特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pmnjtkumu</td><td>保険料免除特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sknnkaisikitkumu</td><td>責任開始期特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gaikatatkiumu</td><td>外貨取扱有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hengakuumu</td><td>変額保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nsikoutkumu</td><td>年金支払移行特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nstkumu</td><td>年金支払特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nstkumu C_Nstkumu}</td></tr>
 *  <tr><td>syksbyensitihsyutktekiumu</td><td>初期死亡時円換算最低保証特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jyudkaigomehrtktekiumu</td><td>重度介護前払特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stknumu</td><td>質権有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>apltekiumu</td><td>ＡＰＬ適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jgyiktumu</td><td>事業一括有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hutuusbhsyumu</td><td>普通死亡保障有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sgsbhsyumu</td><td>災害死亡保障有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sougouiryhsyumu</td><td>総合医療保障有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syuusinhknumu</td><td>終身保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yrhknumu</td><td>養老保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkhknumu</td><td>年金保険有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sipnyukyhumu</td><td>疾病入院給付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sgnyukyhumu</td><td>災害入院給付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sjnyukyhumu</td><td>成人病入院給付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gannyukyhumu</td><td>がん入院給付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kihonsntgkumu</td><td>基本Ｓ日額有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gansdkyhumu</td><td>がん診断給付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ganhsyngumu</td><td>がん保障日額有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>eightysaimnrytkumu</td><td>８０歳満了特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saiteisknwtkumu</td><td>最低Ｓ緩和特約有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dountgkchkumu</td><td>同一日額チェック有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>doukknchkumu</td><td>同一期間チェック有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>doukatachkumu</td><td>同一型チェック有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tyouhukuknyumu</td><td>重複加入チェック有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stsnumu</td><td>Ｓ通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkgnstuusanumu</td><td>年金原資通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nenbtsousbustuusanumu</td><td>年齢別総死亡Ｓ通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>soukktjituhsgktuusanumu</td><td>総告知書実質保障額通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>msnynenbtsbustuusanumu</td><td>未成年用年齢別死亡Ｓ通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktjituhsgk1tuusanumu</td><td>告知書実保障額１通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktjituhsgk2tuusanumu</td><td>告知書実保障額２通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>itijibrptsnumu</td><td>一時払Ｐ通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tkthknsyruitsnkbn</td><td>特定保険種類通算区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkthknsyruitsnKbn C_TkthknsyruitsnKbn}</td></tr>
 *  <tr><td>yenhrkgktuusansiyouumu</td><td>円貨払込金額通算使用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdrtentuusanumu</td><td>契約者同一代理店通算有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>pyennykntktekiumu</td><td>保険料円入金特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>yenshrtktekiumu</td><td>円支払特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gaikanyuukintktekiumu</td><td>外貨入金特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>knrrenkatasyouhnumu</td><td>金利連動型商品有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gstsumu</td><td>源泉徴収対象有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nenmnryumu</td><td>年満了取扱有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kaiyakuhrtype</td><td>解約返戻金支払タイプ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kaiyakuhrtype C_Kaiyakuhrtype}</td></tr>
 *  <tr><td>kaiyakuhrbairitu</td><td>解約返戻金倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>hukkatukanouy</td><td>復活可能年数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hukkatukanoum</td><td>復活可能月数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>pratetani</td><td>Ｐレート単位</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vratetani</td><td>Ｖレート単位</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wratetani</td><td>Ｗレート単位</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kihonssyuruikbn</td><td>基本Ｓ種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>gengakukahikbn</td><td>基本Ｓ減額可否区分</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>pgengakukahikbn</td><td>保険料減額可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>hjnkykumukbn</td><td>法人契約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>creditcardhrtekiumu</td><td>クレジットカード払適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kouzahurikaebaraitekiumu</td><td>口座振替払適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsnshrgndgkhyoujiumu</td><td>通算支払限度額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsnshrgndgk</td><td>通算支払限度額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>itjsytkkziumu</td><td>一時所得課税有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gansknnkaisiymdumu</td><td>がん責任開始日有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gansknnkaisikeikanisuu</td><td>がん責任開始経過日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gantkhktctrlumu</td><td>がん特約復活制御有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>iktpcalcssketasuu</td><td>一括払Ｐ計算小数桁数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tratkikanousinsahou</td><td>取扱可能診査方法</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kostratkiumu</td><td>更新取扱有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kosmnrynen</td><td>更新満了年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrtysysksumu</td><td>支払調書作成有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shrtysyhknsyukbn</td><td>支払調書保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrtysyhknsyuKbn C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>synndkyfknshrskgnumu</td><td>初年度給付金支払削減有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dai1hknkknsbsyokuseiumu</td><td>第１保険期間中死亡保険金額抑制有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hknkknbunruikbn</td><td>保険期間分類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknBunruiKbn C_HknkknBunruiKbn}</td></tr>
 *  <tr><td>mvatekiumu</td><td>ＭＶＡ適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mvatekikkn</td><td>ＭＶＡ適用期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mvatyouseijikou</td><td>ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kaiyakukoujyoritutekiumu</td><td>解約控除率適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kaiyakukoujyoritutekikkn</td><td>解約控除率適用期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkbripfgk</td><td>月払Ｐｆ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hnnnbripfgk</td><td>半年払Ｐｆ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nnbripfgk</td><td>年払Ｐｆ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gwhensyuuoutjyuni</td><td>ＧＷ編集出力順位</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Gwhensyuuoutjyuni C_Gwhensyuuoutjyuni}</td></tr>
 *  <tr><td>koujyosyoumeipkbn</td><td>控除証明保険料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoujyosyoumeipKbn C_KoujyosyoumeipKbn}</td></tr>
 *  <tr><td>zeiseitekikakuumu</td><td>税制適格有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>fatcataisyouumu</td><td>ＦＡＴＣＡ対象有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>aeoitaisyouumu</td><td>ＡＥＯＩ対象有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>houteityotkseiumu</td><td>法定貯蓄性有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>seg2cd</td><td>セグメント２コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>gwhknsyurui</td><td>ＧＷ＿保険種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwhosyucd</td><td>ＧＷ＿保種コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwsyouhncd</td><td>ＧＷ＿商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gwsyouhnnm</td><td>ＧＷ＿商品名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknsyuruikoujyosyoumei</td><td>保険種類（控除証明書）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sknenkinsyu</td><td>新契約年金種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sknenkinsyu C_Sknenkinsyu}</td></tr>
 *  <tr><td>nkuktumu</td><td>年金受取有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tmttknhaibunwarisiteiumu</td><td>積立金配分割合指定有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>targettkhukakanoukbn</td><td>ターゲット特約付加可能区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TargetTkHukaKanouKbn C_TargetTkHukaKanouKbn}</td></tr>
 *  <tr><td>mousideikoukbn</td><td>申出移行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MousideIkouKbn C_MousideIkouKbn}</td></tr>
 *  <tr><td>yendthnksyouhncd</td><td>円建変更後商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sisuukbn</td><td>指数区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sisuukbn C_Sisuukbn}</td></tr>
 *  <tr><td>tyksenhokanhoukbn</td><td>直線補間方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyksenhokanhouKbn C_TyksenhokanhouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SyouhnZokusei
 * @see     GenBM_SyouhnZokusei
 * @see     QBM_SyouhnZokusei
 * @see     GenQBM_SyouhnZokusei
 */
public class PKBM_SyouhnZokusei extends AbstractExDBPrimaryKey<BM_SyouhnZokusei, PKBM_SyouhnZokusei> {

    private static final long serialVersionUID = 1L;

    public PKBM_SyouhnZokusei() {
    }

    public PKBM_SyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
    }

    @Transient
    @Override
    public Class<BM_SyouhnZokusei> getEntityClass() {
        return BM_SyouhnZokusei.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

}