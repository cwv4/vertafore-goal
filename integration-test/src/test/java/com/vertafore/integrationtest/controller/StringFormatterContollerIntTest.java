/*
 *  Copyright 2024 Vertafore, Inc.   All rights reserved.
 *
 *  Disclaimers:
 *   This software is provided "as is," without warranty of any kind, express or
 *   implied, including but not limited to the warranties of merchantability,
 *   fitness for a particular purpose and non-infringement.  This source code
 *   should not be relied upon as the sole basis for solving a problem whose
 *   incorrect solution could result in injury to person or property. In no
 *   event shall the author or contributors be held liable for any damages
 *   arising in any way from the use of this software. The entire risk as to the
 *   results and performance of this source code is assumed by the user.
 *
 *   Permission is granted to use this software for internal use only, subject
 *   to the following restrictions:
 *     1.  This source code MUST retain the above copyright notice, disclaimer,
 *         and this list of conditions.
 *     2.  This source code may be used ONLY within the scope of the original
 *         agreement under which this source code was provided and may not be
 *         distributed to any third party without the express written consent of
 *         Vertafore, Inc.
 *     3.  This source code along with all obligations and rights under the
 *         original License Agreement may not be assigned to any third party
 *         without the expressed written consent of Vertafore, Inc., except that
 *         assignment may be made to a  successor to the business or
 *         substantially all of its assets. All parties bind their successors,
 *         executors, administrators, and assignees to all covenants of this
 *         Agreement.
 *
 *   All advertising materials mentioning features or use of this software must
 *   display the following acknowledgment:
 *
 *     Trademark Disclaimer:
 *     All patent, copyright, trademark and other intellectual property rights
 *     included in the source code are owned exclusively by Vertafore, Inc.
 */

package com.vertafore.integrationtest.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StringFormatterController.class)
class StringFormatterControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testFormatString() throws Exception {
        RequestBuilder request = get("/format_string");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Formatted String: A String", result.getResponse().getContentAsString());
    }

    @Test
    void testFormatString_withStrField() throws Exception {
        mvc.perform(get("/format_string?str=Cool"))
                .andExpect(content().string("Formatted String: Cool"));
    }
}
