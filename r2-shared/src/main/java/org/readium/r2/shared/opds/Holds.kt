/*
 * Module: r2-shared-kotlin
 * Developers: Mickaël Menu
 *
 * Copyright (c) 2020. Readium Foundation. All rights reserved.
 * Use of this source code is governed by a BSD-style license which is detailed in the
 * LICENSE file present in the project repository where this source code is maintained.
 */

package org.readium.r2.shared.opds

import org.json.JSONObject
import org.readium.r2.shared.JSONable
import org.readium.r2.shared.extensions.optPositiveInt
import java.io.Serializable

/**
 * Library-specific features when a specific book is unavailable but provides a hold list.
 *
 * https://drafts.opds.io/schema/properties.schema.json
 */
data class Holds(
    val total: Int? = null,
    val position: Int? = null
) : JSONable, Serializable {

    /**
     * Serializes an [Holds] to its JSON representation.
     */
    override fun toJSON() = JSONObject().apply {
        put("total", total)
        put("position", position)
    }

    companion object {

        /**
         * Creates an [Holds] from its JSON representation.
         */
        fun fromJSON(json: JSONObject?): Holds? {
            json ?: return null
            return Holds(
                total = json.optPositiveInt("total"),
                position = json.optPositiveInt("position")
            )
        }

    }

}
