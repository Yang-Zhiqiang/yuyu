CREATE VIEW ZT_SyoukenTkListSkRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrnatesakitantnm ,         /* （連携用）宛先担当室名(組織名) */
     zrnhozonkkn ,         /* （連携用）保存期間 */
     zrntyouhyouymdwa ,         /* （連携用）帳票作成日（和暦） */
     zrnsagyoukbn ,         /* （連携用）作業区分 */
     zrnyobiv25 ,         /* （連携用）予備項目Ｖ２５ */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnhhknnmkj ,         /* （連携用）被保険者名（漢字） */
     zrntksysyorinaiyou1 ,         /* （連携用）特殊処理内容１ */
     zrntksysyorinaiyou2 ,         /* （連携用）特殊処理内容２ */
     zrntksysyorinaiyou3 ,         /* （連携用）特殊処理内容３ */
     zrntksysyorinaiyou4 ,         /* （連携用）特殊処理内容４ */
     zrntksysyorinaiyou5 ,         /* （連携用）特殊処理内容５ */
     zrntksysyorinaiyou6 ,         /* （連携用）特殊処理内容６ */
     zrntksysyorinaiyou7 ,         /* （連携用）特殊処理内容７ */
     zrntksysyorinaiyou8 ,         /* （連携用）特殊処理内容８ */
     zrntksysyorinaiyou9 ,         /* （連携用）特殊処理内容９ */
     zrntksysyorinaiyou10 ,         /* （連携用）特殊処理内容１０ */
     zrntksysyorinaiyou11 ,         /* （連携用）特殊処理内容１１ */
     zrntksysyorinaiyou12 ,         /* （連携用）特殊処理内容１２ */
     zrntksysyorinaiyou13 ,         /* （連携用）特殊処理内容１３ */
     zrntksysyorinaiyou14 ,         /* （連携用）特殊処理内容１４ */
     zrnbikouupside ,         /* （連携用）備考上段 */
     zrnbikoudownside ,         /* （連携用）備考下段 */
     zrnyobiv37           /* （連携用）予備項目Ｖ３７ */
FROM ZT_SyoukenTkListSkRn_Z;