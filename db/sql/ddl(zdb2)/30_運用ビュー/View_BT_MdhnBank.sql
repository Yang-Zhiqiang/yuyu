CREATE VIEW BT_MdhnBank AS SELECT
     drtencd ,         /* 代理店コード */
     mdhnbankcd ,         /* 窓販銀行コード */
     mdhnhontensitenkbn ,         /* 窓販本店支店区分 */
     mdhnsitencd ,         /* 窓販支店コード */
     mdhncifcdknrkbn ,         /* 窓販ＣＩＦコード管理区分 */
     tkrtkkinyuukntkykbn ,         /* 特例地域金融機関適用区分 */
     tkrtkkinyuukntkyymd ,         /* 特例地域金融機関適用年月日 */
     kydsskkinyuukntkykbn ,         /* 協同組織金融機関適用区分 */
     kydsskkinyuukntkyymd ,         /* 協同組織金融機関適用年月日 */
     mdhntyhyhrtkkbn ,         /* 窓販帳票配列区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_MdhnBank_Z;