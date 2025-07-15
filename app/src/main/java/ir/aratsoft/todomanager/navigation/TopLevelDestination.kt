/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ir.aratsoft.todomanager.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import ir.aratsoft.todomanager.core.designsystem.icon.AppIcons
import ir.aratsoft.todomanager.R
import kotlin.reflect.KClass


enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
//    HOME(
//        selectedIcon = AppIcons.Upcoming,
//        unselectedIcon = AppIcons.UpcomingBorder,
//        iconTextId = homeR.string.feature_home_title,
//        titleTextId = R.string.app_name,
//        route = homeRoute::class,
//        baseRoute = homeBaseRoute::class,
//    ),
//    BOOKMARKS(
//        selectedIcon = AppIcons.Bookmarks,
//        unselectedIcon = AppIcons.BookmarksBorder,
//        iconTextId = bookmarksR.string.feature_bookmarks_title,
//        titleTextId = bookmarksR.string.feature_bookmarks_title,
//        route = BookmarksRoute::class,
//    ),
}
