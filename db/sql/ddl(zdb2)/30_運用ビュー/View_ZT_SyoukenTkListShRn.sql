CREATE VIEW ZT_SyoukenTkListShRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrnatesakitantnm ,         /* （連携用）宛先担当室名(組織名) */
     zrnhozonkkn ,         /* （連携用）保存期間 */
     zrntyouhyouymdwa ,         /* （連携用）帳票作成日（和暦） */
     zrnyobiv26 ,         /* （連携用）予備項目Ｖ２６ */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnkyknmkj ,         /* （連携用）契約者名（漢字） */
     zrnhhknnmkj ,         /* （連携用）被保険者名（漢字） */
     zrnsyorinm ,         /* （連携用）処理名(機能名) */
     zrnsyorisyouninsyacd ,         /* （連携用）処理承認者コード */
     zrnsyorisyouninsyanm ,         /* （連携用）処理承認者名 */
     zrnjigosagyounaiyo1 ,         /* （連携用）事後作業内容１ */
     zrnjigosagyounaiyo2 ,         /* （連携用）事後作業内容２ */
     zrnjigosagyounaiyo3 ,         /* （連携用）事後作業内容３ */
     zrnjigosagyounaiyo4 ,         /* （連携用）事後作業内容４ */
     zrnjigosagyounaiyo5 ,         /* （連携用）事後作業内容５ */
     zrnjigosagyounaiyo6 ,         /* （連携用）事後作業内容６ */
     zrnjigosagyounaiyo7 ,         /* （連携用）事後作業内容７ */
     zrnjigosagyounaiyo8 ,         /* （連携用）事後作業内容８ */
     zrnjigosagyounaiyo9 ,         /* （連携用）事後作業内容９ */
     zrnjigosagyounaiyo10 ,         /* （連携用）事後作業内容１０ */
     zrnjigosagyounaiyo11 ,         /* （連携用）事後作業内容１１ */
     zrnjigosagyounaiyo12 ,         /* （連携用）事後作業内容１２ */
     zrnjigosagyounaiyo13 ,         /* （連携用）事後作業内容１３ */
     zrnjigosagyounaiyo14 ,         /* （連携用）事後作業内容１４ */
     zrnjigosagyounaiyo15 ,         /* （連携用）事後作業内容１５ */
     zrnjigosagyounaiyo16 ,         /* （連携用）事後作業内容１６ */
     zrnyobiv31           /* （連携用）予備項目Ｖ３１ */
FROM ZT_SyoukenTkListShRn_Z;