CREATE VIEW IT_BAK_SeihowebIdouRireki AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     henkousikibetukey ,         /* 変更識別キー */
     idouhasseiym ,         /* 異動発生年月 */
     idouhasseiymd ,         /* 異動発生年月日 */
     seihowebidoukbnnaiyou1 ,         /* 生保Ｗｅｂ異動区分内容１ */
     seihowebidoukbnnaiyou2 ,         /* 生保Ｗｅｂ異動区分内容２ */
     dairitencd1 ,         /* 代理店コード１ */
     bosyuucd1 ,         /* 募集人コード１ */
     drtenbunumu ,         /* 代理店分担有無 */
     dairitencd2 ,         /* 代理店コード２ */
     bosyuucd2 ,         /* 募集人コード２ */
     hrkkaisuu ,         /* 払込回数 */
     tikiktbrisyuruikbn ,         /* 定期一括払種類区分 */
     hrkkeiro ,         /* 払込経路 */
     bosyuuym ,         /* 募集年月 */
     cifcd ,         /* ＣＩＦコード */
     bankcd ,         /* 銀行コード */
     jkipjytym ,         /* 次回Ｐ充当年月 */
     kyknmkj ,         /* 契約者名（漢字） */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     kykymd ,         /* 契約日 */
     hokenryou ,         /* 保険料 */
     hokenryou$ ,         /* 保険料(通貨型) */
     tuukasyu ,         /* 通貨種類 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_SeihowebIdouRireki_Z;