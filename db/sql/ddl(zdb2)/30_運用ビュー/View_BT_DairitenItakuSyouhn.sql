CREATE VIEW BT_DairitenItakuSyouhn AS SELECT
     drtencd ,         /* 代理店コード */
     drtsyouhinsikibetukbnstr ,         /* 代理店商品識別区分（文字列） */
     drthrkhouhoukbn ,         /* 代理店払込方法区分 */
     drtplannmkbn ,         /* 代理店プラン名区分 */
     itakuhknhnbkaisiymd ,         /* 委託保険販売開始年月日 */
     itakuhknhnbsyuuryouymd ,         /* 委託保険販売終了年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_DairitenItakuSyouhn_Z;