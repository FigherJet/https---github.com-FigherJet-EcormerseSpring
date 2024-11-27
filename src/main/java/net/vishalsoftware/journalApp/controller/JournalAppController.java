package net.vishalsoftware.journalApp.controller;

import ch.qos.logback.classic.joran.JoranConfigurator;
import net.vishalsoftware.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class JournalAppController {

     private Map<Long , JournalEntry> journalEntry = new HashMap<>();


     @GetMapping
     public List<JournalEntry> getAll()
     {
          return new ArrayList<>(journalEntry.values());
     }

     @PostMapping
     public void createEntry(@RequestBody JournalEntry myEntries)
     {
          journalEntry.put(myEntries.getId(),myEntries);
     }

     @GetMapping("id/{myId}")
     public JournalEntry journalEntries(@PathVariable Long myId)
     {
          return journalEntry.get(myId);
     }

     @DeleteMapping("id/{myId}")
     public JournalEntry deleteJournalEntries(@PathVariable Long myId)
     {
           return journalEntry.remove(myId);
     }

     @PutMapping("id/{id}")
     public JournalEntry updateJournalEntries(@PathVariable long id, @RequestBody JournalEntry myEntry )
     {
          return journalEntry.put(id,myEntry);
     }

}
