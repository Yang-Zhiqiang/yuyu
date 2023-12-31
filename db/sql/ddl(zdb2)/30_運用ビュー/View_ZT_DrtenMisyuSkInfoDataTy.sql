CREATE VIEW ZT_DrtenMisyuSkInfoDataTy AS SELECT
     ztysyono ,         /* （中継用）証券番号 */
     ztybsydrtencd ,         /* （中継用）募集代理店コード */
     ztykykymd ,         /* （中継用）契約年月日 */
     ztyhnsyugknjkyksynm ,         /* （中継用）編集後漢字契約者名 */
     ztyknjhhknmei ,         /* （中継用）漢字被保険者名 */
     ztykykjyutikbn ,         /* （中継用）契約状態区分 */
     ztytsinkihontikucd ,         /* （中継用）通信先基本地区コード */
     ztykanjitsinkaiadr ,         /* （中継用）漢字通信先下位住所 */
     ztytsintelno ,         /* （中継用）通信先電話番号 */
     ztydai2tsintelno ,         /* （中継用）第２通信先電話番号 */
     ztykzhurikaebankcd ,         /* （中継用）口座振替銀行番号 */
     ztykzhurikaesitencd ,         /* （中継用）口座振替支店番号 */
     ztykzhurikaeyokinkbn ,         /* （中継用）口座振替預金種目区分 */
     ztykzhurikaekouzano ,         /* （中継用）口座振替口座番号 */
     ztykzhurikaemeiginm ,         /* （中継用）口座振替名義人名 */
     ztyhrkkaisuukbn ,         /* （中継用）払込回数区分 */
     ztyyobiv6x5 ,         /* （中継用）予備項目Ｖ６＿５ */
     zty1kaip ,         /* （中継用）１回分保険料 */
     ztynexthurikaeyoteigk ,         /* （中継用）次回振替予定金額 */
     ztyhrkyykknmnryymd ,         /* （中継用）払込猶予期間満了日 */
     ztyskymd ,         /* （中継用）失効年月日 */
     ztyjhurikstkkahikbn ,         /* （中継用）自動振替貸付可否区分 */
     ztyhukkatumoskahikbn ,         /* （中継用）復活申込可否区分 */
     ztyttdkkigenymd ,         /* （中継用）手続き期限年月日 */
     ztyhukkatukanoukknmnryymd ,         /* （中継用）復活可能期間満了年月日 */
     ztykeikatukisuu3keta ,         /* （中継用）経過月数（３桁） */
     ztymisyuuhasseiym ,         /* （中継用）未収発生年月 */
     ztymisyuujiyuu ,         /* （中継用）未収事由 */
     ztyhanteiymd ,         /* （中継用）判定年月日 */
     ztyyobin11 ,         /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2 ,         /* （中継用）予備項目Ｎ１１＿２ */
     ztynexthurikaeymd ,         /* （中継用）次回振替年月日 */
     ztyyobiv8x3 ,         /* （中継用）予備項目Ｖ８＿３ */
     ztyikkatubaraikbn ,         /* （中継用）一括払区分 */
     ztyikkatubaraikaisuu ,         /* （中継用）一括払回数 */
     ztyyobiv55 ,         /* （中継用）予備項目Ｖ５５ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_DrtenMisyuSkInfoDataTy_Z;