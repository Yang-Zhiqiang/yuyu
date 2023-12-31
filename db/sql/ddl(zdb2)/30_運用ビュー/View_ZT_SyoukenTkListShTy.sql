CREATE VIEW ZT_SyoukenTkListShTy AS SELECT
     ztysyoruicd ,         /* （中継用）書類コード */
     ztytyouhyouymd ,         /* （中継用）帳票作成日 */
     ztyhassoukbn ,         /* （中継用）発送区分 */
     ztyatesakitantnm ,         /* （中継用）宛先担当室名(組織名) */
     ztyhozonkkn ,         /* （中継用）保存期間 */
     ztytyouhyouymdwa ,         /* （中継用）帳票作成日（和暦） */
     ztyyobiv26 ,         /* （中継用）予備項目Ｖ２６ */
     ztysyono ,         /* （中継用）証券番号 */
     ztykyknmkj ,         /* （中継用）契約者名（漢字） */
     ztyhhknnmkj ,         /* （中継用）被保険者名（漢字） */
     ztysyorinm ,         /* （中継用）処理名(機能名) */
     ztysyorisyouninsyacd ,         /* （中継用）処理承認者コード */
     ztysyorisyouninsyanm ,         /* （中継用）処理承認者名 */
     ztyjigosagyounaiyo1 ,         /* （中継用）事後作業内容１ */
     ztyjigosagyounaiyo2 ,         /* （中継用）事後作業内容２ */
     ztyjigosagyounaiyo3 ,         /* （中継用）事後作業内容３ */
     ztyjigosagyounaiyo4 ,         /* （中継用）事後作業内容４ */
     ztyjigosagyounaiyo5 ,         /* （中継用）事後作業内容５ */
     ztyjigosagyounaiyo6 ,         /* （中継用）事後作業内容６ */
     ztyjigosagyounaiyo7 ,         /* （中継用）事後作業内容７ */
     ztyjigosagyounaiyo8 ,         /* （中継用）事後作業内容８ */
     ztyjigosagyounaiyo9 ,         /* （中継用）事後作業内容９ */
     ztyjigosagyounaiyo10 ,         /* （中継用）事後作業内容１０ */
     ztyjigosagyounaiyo11 ,         /* （中継用）事後作業内容１１ */
     ztyjigosagyounaiyo12 ,         /* （中継用）事後作業内容１２ */
     ztyjigosagyounaiyo13 ,         /* （中継用）事後作業内容１３ */
     ztyjigosagyounaiyo14 ,         /* （中継用）事後作業内容１４ */
     ztyjigosagyounaiyo15 ,         /* （中継用）事後作業内容１５ */
     ztyjigosagyounaiyo16 ,         /* （中継用）事後作業内容１６ */
     ztyyobiv31 ,         /* （中継用）予備項目Ｖ３１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SyoukenTkListShTy_Z;