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

package xyz.calebwarner.embeddeddata.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.calebwarner.embeddeddata.data.PerformanceRepository;
import xyz.calebwarner.embeddeddata.model.Performance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PerformanceService {
    
    private static final Logger LOG = LoggerFactory.getLogger(PerformanceService.class);
    
    private final PerformanceRepository performanceRepository;
    
    public PerformanceService(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }
    
    public List<Performance> saveDefaultPerformances() {
        List<Performance> performanceList = new ArrayList<>();

        performanceList.add(Performance.builder().title("Hailey in the park").location("Hailey Concert Hall").date(LocalDate.of(2022, 7, 26)).description("The Hailey Concert Band performs at Hailey Concert Hall").build());
        performanceList.add(Performance.builder().title("Elton John et al").location("Elton John Memorial Park").date(LocalDate.of(2022, 4, 14)).description("Bands perform songs by and inspired by Elton John at Memorial Park").build());
        performanceList.add(Performance.builder().title("Sax and Stuff").location("Trinity Park Amphitheater").date(LocalDate.of(2022, 5, 9)).description("The Six Toned Saxes perform at Trinity Park Amphitheater").build());
        performanceList.add(Performance.builder().title("Marching Band Halftime").location("Nelson Stadium").date(LocalDate.of(2022, 9, 12)).description("The University Marching Band performs at halftime at Nelson Stadium").build());
        performanceList.add(Performance.builder().title("Bum-ba-dum-drum").location("Hancock Performing Arts Center").date(LocalDate.of(2022, 12, 3)).description("The percussionists of the Green Women Group perform at the Hancock PAC").build());

        performanceRepository.saveAll(performanceList);

        return performanceList;
    }

    public List<Performance> testPerformanceClass() {
        List<Performance> performanceList = saveDefaultPerformances();

        LOG.info("--------------------------------------------");
        LOG.info("findAll(), expecting 4 books:");
        for (Performance performance : performanceRepository.findAll()) {
            LOG.info("{}", performance);
        }
        LOG.info("");

        return performanceList;
    }

}
